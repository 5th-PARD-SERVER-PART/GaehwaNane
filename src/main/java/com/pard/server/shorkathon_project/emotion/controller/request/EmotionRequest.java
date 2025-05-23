package com.pard.server.shorkathon_project.emotion.controller.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pard.server.shorkathon_project.emotion.service.dto.EmotionDto;
import com.pard.server.shorkathon_project.user.service.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmotionRequest {

    private String content;
    private LocalDate createdDate;

    public EmotionDto toDto() {
        return EmotionDto.builder()
                .content(content)
                .createdDate(createdDate)
                .build();
    }

}
