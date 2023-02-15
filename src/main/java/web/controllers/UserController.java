package web.controllers;

import dto.SaveUserDTO;
import dto.UserDTO;
import dto.UserPageDTO;
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
    public SaveUserDTO get(@PathVariable("uuid") UUID userUUID) {
        return userService.get(userUUID);
    }

    @RequestMapping(path = "{uuid}/dt_update/{dt_update}", method = RequestMethod.PUT)
    public void update(@PathVariable("id") UUID userUUID,
                       @PathVariable("dt_update") LocalDateTime dtUpdate,
                       @RequestBody UserDTO userDTO) {
        userService.update(userUUID, dtUpdate, userDTO);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody UserDTO usersDTO) {
        userService.create(usersDTO);
    }

    @RequestMapping(method = RequestMethod.GET)
    public UserPageDTO get(int page, int size) {
        return userService.get(page, size);
    }
}
