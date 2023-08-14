package com.lion2.lion2.dto.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberUsernameUpdateDTO {

    @NotBlank(message = "전화번호를 입력해주세요.")
    private String phone;

    @NotBlank(message = "이름을 입력해주세요.")
    @Size(min = 2, max = 15, message = "이름은 2 ~ 15자 사이로 입력해주세요.")
    private String username;
}