package service.api;

import core.dto.SaveUserDTO;
import core.dto.UserLogInDTO;
import core.dto.UserRegistrationDTO;

public interface IPersonAreaService {
    void logIn(UserLogInDTO userLogInDTO);

    void registration(UserRegistrationDTO userRegistrationDTO);

    void verification(String code,String mail);

    SaveUserDTO infoAboutMe();
}
