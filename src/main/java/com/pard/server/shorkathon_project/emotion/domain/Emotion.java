package com.pard.server.shorkathon_project.emotion.domain;

import com.pard.server.shorkathon_project.emotion.service.dto.EmotionDto;
import com.pard.server.shorkathon_project.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Emotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private LocalDate createdDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public static Emotion from(String content, LocalDate createdDate, User user) {
        return new Emotion(null, content, createdDate, user);
    }

    public void updateEmotion(String content) {
        this.content = content;
    }
}
