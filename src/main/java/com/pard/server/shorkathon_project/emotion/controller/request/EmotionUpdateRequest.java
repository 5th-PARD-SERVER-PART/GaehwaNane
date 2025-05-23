package com.pard.server.shorkathon_project.emotion.controller.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pard.server.shorkathon_project.emotion.service.dto.EmotionDto;
import com.pard.server.shorkathon_project.emotion.service.dto.EmotionUpdateDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmotionUpdateRequest {

    private String content;

    public EmotionUpdateDto toDto() {
        return EmotionUpdateDto.builder()
                .content(content)
                .build();
    }
}
