package com.pard.server.shorkathon_project.user.controller;

import com.pard.server.shorkathon_project.user.controller.request.UserRequest;
import com.pard.server.shorkathon_project.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public void createUser(@RequestBody UserRequest request) {
        userService.createUser(request.toDto());
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}
