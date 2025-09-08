package com.errday.elasticsearcbasic;

import lombok.Getter;

@Getter
public class UserUpdateRequestDto {

    private String name;
    private Long age;
    private Boolean isActive;
}
