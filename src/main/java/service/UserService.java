package service;

import dao.api.IUserDao;
import core.dto.SaveUserDTO;
import core.dto.UserDTO;
import core.dto.UserPageDTO;
import entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import service.api.IUserService;
import userEnum.RoleUser;
import userEnum.Status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserService implements IUserService {

    private final IUserDao dao;


    public UserService(IUserDao dao) {
        this.dao = dao;
    }

    @Override
    public void create(UserDTO userDTO) {
        String fio = userDTO.getFio();
        String mail = userDTO.getMail();
        String password = userDTO.getPassword();
        UUID uuid = UUID.randomUUID();
        LocalDateTime dtCreate = LocalDateTime.now();
        RoleUser roleUser = userDTO.getRole();
        Status status = userDTO.getStatus();
        if (fio == null || fio.isBlank()) {
            throw new IllegalArgumentException("Введите ФИО");
        } else if (mail == null || mail.isBlank()) {
            throw new IllegalArgumentException("Введите почту");
        } else if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Введите пароль");
        } else if (roleUser == null || password.isBlank()) {
            throw new IllegalArgumentException("Введите роль");
        } else if (status == null || password.isBlank()) {
            throw new IllegalArgumentException("Введите статус");
        } else {
            dao.create(new UserEntity(uuid, mail, fio, password, dtCreate, dtCreate, roleUser, status));
        }
    }

    @Override
    public UserPageDTO get(int page, int size) {
        int numberOfUsersPerPage = 20;
        int totalPages;
        boolean first = false;
        boolean last = false;

        List<SaveUserDTO> usersPages = new ArrayList<>();
        List<UserEntity> userEntities = dao.getUserList();

        int totalElements = userEntities.size();
        if (totalElements % numberOfUsersPerPage == 0) {
            totalPages = (int) Math.floor(totalElements / numberOfUsersPerPage);
        } else {
            totalPages = (int) Math.floor(totalElements / numberOfUsersPerPage) + 1;
        }
        int countEmptyLine = totalPages * numberOfUsersPerPage - totalElements;
        int numberOfUsersPerLastPage = numberOfUsersPerPage - countEmptyLine;
        if (page == 1) {
            first = true;
        }
        if (page == totalPages) {
            last = true;
        }
        if (page == 0 || page > totalPages || page < 0) {
            throw new IllegalArgumentException("Страницы № " + page + " не существует");
        }
        if (size == 0 || size > numberOfUsersPerLastPage || size < 0) {
            throw new IllegalArgumentException("Пользователь не существует");
        }

        for (int i = size * page; i < userEntities.size(); i++) {
            UserEntity user = userEntities.get(i);
            usersPages.add(new SaveUserDTO(user.getUuid(), user.getDtCreate(), user.getDtUpdate(),
                    user.getMail(), user.getFio(), user.getRole(), user.getStatus()));
        }
        return new UserPageDTO(page, size, totalPages, totalElements, first, numberOfUsersPerLastPage, last, usersPages);
    }


    @Override
    public SaveUserDTO get(UUID uuid) {
        UserEntity userEntity = this.dao.get(uuid);
        return new SaveUserDTO(userEntity.getUuid(), userEntity.getDtCreate(), userEntity.getDtUpdate(), userEntity.getMail(), userEntity.getFio(), userEntity.getRole(), userEntity.getStatus());
    }

    @Override
    public void update(UUID uuid, LocalDateTime dtUpdate, UserDTO userDTO) {

        if (dtUpdate == null) {
            throw new IllegalArgumentException("Введите ФИО");
        }
        if (uuid == null) {
            throw new IllegalArgumentException("Введите id");
        }
        if (dao.isContain(uuid)) {
            UserEntity entity = dao.get(uuid);
            if (entity.getDtCreate() == dtUpdate) {
                dao.update(new UserEntity(uuid, userDTO.getMail(), userDTO.getFio(), userDTO.getPassword(), dao.get(uuid).getDtCreate(), LocalDateTime.now(), userDTO.getRole(), userDTO.getStatus()));
            } else {
                throw new IllegalArgumentException("Введена не верная версия");
            }
        } else {
            throw new IllegalArgumentException("Нет пользователя для обновления с таким id");
        }
    }
}
