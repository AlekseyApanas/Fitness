package service.api;

import dto.SaveUserDTO;
import dto.UserLogInDTO;
import dto.UserRegistrationDTO;

public interface IPersonAreaService {
    void logIn(UserLogInDTO userLogInDTO);

    void registration(UserRegistrationDTO userRegistrationDTO);

    void verification(String code);

    SaveUserDTO infoAboutMe();
}
