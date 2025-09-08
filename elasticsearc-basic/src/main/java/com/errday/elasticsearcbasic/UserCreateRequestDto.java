package com.errday.elasticsearcbasic;

import lombok.Getter;

@Getter
public class UserCreateRequestDto {

    private String id;
    private String name;
    private Long age;
    private Boolean isActive;
}
