package service;

import dto.SaveUserDTO;
import dto.UserDTO;
import dto.UserPageDTO;
import service.api.IUserService;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserService implements IUserService {
    @Override
    public void create(UserDTO userDTO) {

    }

    @Override
    public UserPageDTO get(int page, int size) {
        return null;
    }

    @Override
    public SaveUserDTO get(UUID uuid) {
        return null;
    }

    @Override
    public void update(UUID id, LocalDateTime dtUpdate, UserDTO userDTO) {

    }
}
