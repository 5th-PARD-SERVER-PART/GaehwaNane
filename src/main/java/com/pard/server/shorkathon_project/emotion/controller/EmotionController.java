package com.pard.server.shorkathon_project.emotion.controller;

import com.pard.server.shorkathon_project.emotion.controller.request.EmotionRequest;
import com.pard.server.shorkathon_project.emotion.controller.request.EmotionUpdateRequest;
import com.pard.server.shorkathon_project.emotion.service.EmotionService;
import com.pard.server.shorkathon_project.emotion.service.dto.EmotionDto;
import com.pard.server.shorkathon_project.emotion.service.dto.EmotionUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/emotion")
public class EmotionController {

    private final EmotionService emotionService;

    @PostMapping("/{userId}")
    public void createEmotion(@PathVariable Long userId, @RequestBody EmotionRequest req) {
        emotionService.createEmotion(userId, req.toDto());
    }

    @GetMapping("/{userId}")
    public List<EmotionDto> getEmotion(@PathVariable Long userId) {
        return emotionService.findByUserId(userId);
    }

    @PatchMapping("/{emotionId}")
    public void updateEmotion(@PathVariable Long emotionId, @RequestBody EmotionUpdateRequest req) {
        emotionService.updateEmotion(emotionId, req.toDto());
    }

    @DeleteMapping("/{emotionId}")
    public void deleteEmotion(@PathVariable Long emotionId) {
        emotionService.deleteEmotion(emotionId);
    }
}
