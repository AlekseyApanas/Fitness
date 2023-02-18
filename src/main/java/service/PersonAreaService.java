package service;

import core.dto.SaveUserDTO;
import core.dto.UserLogInDTO;
import core.dto.UserRegistrationDTO;
import dao.api.IUserDao;
import entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import service.api.IPersonAreaService;
import userEnum.RoleUser;
import userEnum.Status;

import java.time.LocalDateTime;
import java.util.UUID;

public class PersonAreaService implements IPersonAreaService {
    private IUserDao dao;


    public PersonAreaService( IUserDao dao) {
        this.dao = dao;
    }

    @Override
    public void logIn(UserLogInDTO userLogInDTO) {
        String login = userLogInDTO.getMail();

        if (login == null || login.isBlank()) {
            throw new IllegalArgumentException("Login not entered");
        }

        String password = userLogInDTO.getPassword();

        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password not entered");
        }
        //проверить на наличие такого пользователя
    }

    @Override
    public void registration(UserRegistrationDTO userRegistrationDTO) {
        String fio = userRegistrationDTO.getFio();
        String mail = userRegistrationDTO.getMail();
        String password = userRegistrationDTO.getPassword();
        UUID uuid = UUID.randomUUID();
        LocalDateTime dtCreate = LocalDateTime.now();
        RoleUser roleUser = RoleUser.USER;
        Status status = Status.WAITING_ACTIVATION;
        if (fio == null || fio.isBlank()) {
            throw new IllegalArgumentException("Введите ФИО");
        } else if (mail == null || mail.isBlank()) {
            throw new IllegalArgumentException("Введите почту");
        } else if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Введите пароль");
        } else {
            dao.create(new UserEntity(uuid, mail, fio, password, dtCreate, dtCreate, roleUser, status));
        }
        //отправка сообщения на mail для верификации
    }

    @Override
    public void verification(String code, String mail) {

    }

    @Override
    public SaveUserDTO infoAboutMe() {
        return null;
    }
}
