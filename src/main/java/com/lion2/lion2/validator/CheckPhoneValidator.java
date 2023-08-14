package com.lion2.lion2.validator;

import com.lion2.lion2.dto.member.MemberSaveRequestDTO;
import com.lion2.lion2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
@RequiredArgsConstructor
public class CheckPhoneValidator extends AbstractValidator<MemberSaveRequestDTO> {

    private final MemberRepository memberRepository;

    @Override
    protected void doValidate(MemberSaveRequestDTO dto, Errors errors) {
        if(memberRepository.existsByPhone(dto.getPhone())) {
            errors.rejectValue("phone", "전화번호 중복 오류", "이미 사용중인 전화번호 입니다.");
        }
    }
}