package web.controllers;

import core.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.api.IPersonAreaService;

@RestController
@RequestMapping("/api/v1/users")
public class PersonAreaController {
    private IPersonAreaService iPersonArea;

    public PersonAreaController(IPersonAreaService iPersonArea) {
        this.iPersonArea = iPersonArea;
    }

    @RequestMapping(path = "/registration", method = RequestMethod.POST)
    public ResponseEntity<?> registration(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        iPersonArea.registration(userRegistrationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(path = "/verification", method = RequestMethod.GET)
    public ResponseEntity<?> verification(String code, String mail) {
        iPersonArea.verification(code, mail);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> logIn(@RequestBody UserLogInDTO userLogInDTO) {
        iPersonArea.logIn(userLogInDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(path = "/me", method = RequestMethod.GET)
    public ResponseEntity<SaveUserDTO> get() {
        return ResponseEntity.status(HttpStatus.CREATED).body(iPersonArea.infoAboutMe());
    }
}
