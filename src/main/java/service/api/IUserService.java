package service.api;

import dto.SaveUserDTO;
import dto.UserDTO;
import dto.UserPageDTO;

import java.time.LocalDateTime;
import java.util.UUID;

public interface IUserService {
    void create(UserDTO userDTO);

    UserPageDTO get(int page, int size);

    SaveUserDTO get(UUID id);

    void update(UUID id, LocalDateTime dtUpdate, UserDTO userDTO);
}
