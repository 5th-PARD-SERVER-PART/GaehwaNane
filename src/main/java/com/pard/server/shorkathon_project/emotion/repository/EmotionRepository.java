package com.pard.server.shorkathon_project.emotion.repository;

import com.pard.server.shorkathon_project.emotion.domain.Emotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmotionRepository extends JpaRepository<Emotion, Long> {
    List<Emotion> findByUserId(Long userId);
}
