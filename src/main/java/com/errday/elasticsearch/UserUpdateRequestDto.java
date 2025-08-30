package com.errday.elasticsearch;

import lombok.Getter;

@Getter
public class UserUpdateRequestDto {

    private String name;
    private Long age;
    private Boolean isActive;
}
