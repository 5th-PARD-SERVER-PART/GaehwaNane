package com.pard.server.shorkathon_project.emotion.service;

import com.pard.server.shorkathon_project.emotion.domain.Emotion;
import com.pard.server.shorkathon_project.emotion.repository.EmotionRepository;
import com.pard.server.shorkathon_project.emotion.service.dto.EmotionDto;
import com.pard.server.shorkathon_project.emotion.service.dto.EmotionUpdateDto;
import com.pard.server.shorkathon_project.user.domain.User;
import com.pard.server.shorkathon_project.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmotionService {

    private final EmotionRepository emotionRepository;
    private final UserRepository userRepository;

    public void createEmotion(Long userId, EmotionDto emotionDto) {
        Optional<User> user = userRepository.findById(userId);
        User u = user.get();
        List<String> lines = splitByLength(emotionDto.getContent(), 25);
        String content = String.join("\n", lines);
        Emotion emotion = Emotion.from(content,emotionDto.getCreatedDate(),u);
        emotionRepository.save(emotion);
    }

    public List<String> splitByLength(String content, int size) {
        List<String> result = new ArrayList<>();
        int length = content.length();

        for (int i = 0; i < length; i += size) {
            int end = Math.min(i + size, length);
            result.add(content.substring(i, end));
        }
        return result;
    }

    public List<EmotionDto> findByUserId(Long userId) {
        List<Emotion> emotions = emotionRepository.findByUserId(userId);
        List<EmotionDto> emotionDtos = emotions.stream().map(
                emotion -> EmotionDto.builder()
                        .content(emotion.getContent())
                        .createdDate(emotion.getCreatedDate())
                        .build()
        ).toList();
        return emotionDtos;
    }

    @Transactional
    public void updateEmotion(Long id, EmotionUpdateDto emotionUpdateDto) {
        Emotion emotion = emotionRepository.findById(id).get();
        List<String> lines = splitByLength(emotionUpdateDto.getContent(), 25);
        String content = String.join("\n", lines);
        emotion.updateEmotion(content);
        emotionRepository.save(emotion);
    }

    public void deleteEmotion(Long id) {
        emotionRepository.deleteById(id);
    }
}
