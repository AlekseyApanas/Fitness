package service.api;

import core.dto.SaveUserDTO;
import core.dto.UserDTO;
import core.dto.UserPageDTO;

import java.time.LocalDateTime;
import java.util.UUID;

public interface IUserService {
    void create(UserDTO userDTO);

    UserPageDTO get(int page, int size);

    SaveUserDTO get(UUID id);

    void update(UUID id, LocalDateTime dtUpdate, UserDTO userDTO);
}
