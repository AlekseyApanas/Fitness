package web.controllers;

import dto.*;
import org.springframework.web.bind.annotation.*;
import service.api.IPersonAreaService;

@RestController
@RequestMapping("/api/v1/users")
public class PersonAreaController {
    private IPersonAreaService iPersonArea;

    public PersonAreaController(IPersonAreaService iPersonArea) {
        this.iPersonArea = iPersonArea;
    }
    @RequestMapping(path = "/registration",method = RequestMethod.POST)
    public void registration(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        iPersonArea.registration(userRegistrationDTO);
    }
    @RequestMapping(path = "/verification", method = RequestMethod.GET)
    public void verification(String code) {
        iPersonArea.verification(code);
    }

    @RequestMapping(path = "/login",method = RequestMethod.POST)
    public void logIn(@RequestBody UserLogInDTO userLogInDTO) {
        iPersonArea.logIn(userLogInDTO);
    }

    @RequestMapping(path = "/me",method = RequestMethod.GET)
    public SaveUserDTO get() {
        return iPersonArea.infoAboutMe();
    }
}
