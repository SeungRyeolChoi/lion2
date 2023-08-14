package com.lion2.lion2.dto.member;


import com.lion2.lion2.domain.Member;
import com.lion2.lion2.domain.Role;
import lombok.*;

@Getter
@NoArgsConstructor
public class MemberResponseDTO {

    private String phone;
    private String username;
    private Role role;

    @Builder
    public MemberResponseDTO(Member member) {
        this.phone = member.getPhone();
        this.username = member.getUsername();
        this.role = member.getRole();
    }
}