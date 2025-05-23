package com.pard.server.shorkathon_project.user.controller.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pard.server.shorkathon_project.user.service.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRequest {

    private String name;

    public UserDto toDto() {
        return UserDto.builder()
                .name(name)
                .build();
    }
}
