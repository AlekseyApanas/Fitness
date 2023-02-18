package web.controllers;

import core.dto.SaveUserDTO;
import core.dto.UserDTO;
import core.dto.UserPageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.api.IUserService;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")

public class UserController {
    private final IUserService userService;

    public UserController(IUserService iUserService) {
        this.userService = iUserService;
    }

    @RequestMapping(path = "/{uuid}", method = RequestMethod.GET)
    public ResponseEntity<SaveUserDTO> get(@PathVariable("uuid") UUID userUUID) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.get(userUUID));
    }

    @RequestMapping(path = "{uuid}/dt_update/{dt_update}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable("id") UUID userUUID,
                                    @PathVariable("dt_update") LocalDateTime dtUpdate,
                                    @RequestBody UserDTO userDTO) {
        userService.update(userUUID, dtUpdate, userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody UserDTO usersDTO) {
        userService.create(usersDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<UserPageDTO> get(int page, int size) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.get(page, size));
    }
}
