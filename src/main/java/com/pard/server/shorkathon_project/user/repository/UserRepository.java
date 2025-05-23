package com.pard.server.shorkathon_project.user.repository;

import com.pard.server.shorkathon_project.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
