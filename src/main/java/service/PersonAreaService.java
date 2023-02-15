package service;

import dto.SaveUserDTO;
import dto.UserLogInDTO;
import dto.UserRegistrationDTO;
import service.api.IPersonAreaService;

public class PersonAreaService implements IPersonAreaService {
    @Override
    public void logIn(UserLogInDTO userLogInDTO) {

    }

    @Override
    public void registration(UserRegistrationDTO userRegistrationDTO) {

    }

    @Override
    public void verification(String code) {

    }

    @Override
    public SaveUserDTO infoAboutMe() {
        return null;
    }
}
