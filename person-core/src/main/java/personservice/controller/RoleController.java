package personservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import personservice.model.UserEntity;
import personservice.service.UserService;

@RestController
@RequestMapping("/user")
public class RoleController {

    UserService userService;

    public RoleController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{name}")
    UserEntity findUser (@PathVariable String name){
        return userService.findByUsername(name).orElseThrow(RuntimeException::new);
    }
}
