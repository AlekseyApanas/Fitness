package service.api;

import dto.SaveUserDTO;
import dto.UserDTO;
import dto.UserLogInDTO;
import dto.UserRegistrationDTO;

public interface IPersonArea {
    void logIn(UserLogInDTO userLogInDTO);

    void registration(UserRegistrationDTO userRegistrationDTO);

    void verification(String code);

    SaveUserDTO infoAboutMe();
}
