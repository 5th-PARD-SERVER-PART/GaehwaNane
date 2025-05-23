package com.pard.server.shorkathon_project.user.service;

import com.pard.server.shorkathon_project.user.domain.User;
import com.pard.server.shorkathon_project.user.repository.UserRepository;
import com.pard.server.shorkathon_project.user.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(UserDto user) {
        User user1 = new User(null, user.getName());
        userRepository.save(user1);
    }

    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(IllegalAccessError::new);
        userRepository.delete(user);
    }
}
