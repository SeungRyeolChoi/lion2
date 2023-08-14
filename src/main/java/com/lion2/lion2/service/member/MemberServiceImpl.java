package com.lion2.lion2.service.member;


import com.lion2.lion2.domain.Member;
import com.lion2.lion2.dto.member.MemberPasswordUpdateDTO;
import com.lion2.lion2.dto.member.MemberResponseDTO;
import com.lion2.lion2.dto.member.MemberUsernameUpdateDTO;
import com.lion2.lion2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<MemberResponseDTO> findMembers() {
        List<Member> all = memberRepository.findAll();
        List<MemberResponseDTO> members = new ArrayList<>();

        for (Member member: all) {
            MemberResponseDTO build = MemberResponseDTO.builder()
                    .member(member)
                    .build();
            members.add(build);
        }

        return members;
    }

    @Override
    public MemberResponseDTO findMember(String phone) {
        Member member = memberRepository.findByPhone(phone).orElseThrow(() -> new UsernameNotFoundException("전화번호가 존재하지 않습니다."));

        MemberResponseDTO result = MemberResponseDTO.builder()
                .member(member)
                .build();

        return result;
    }

    @Override
    public Long updateMemberUsername(MemberUsernameUpdateDTO memberUsernameUpdateDTO) {
        Member member = memberRepository.findByPhone(memberUsernameUpdateDTO.getPhone()).orElseThrow(() -> new UsernameNotFoundException("전화번호가 존재하지 않습니다."));

        member.updateUsername(memberUsernameUpdateDTO.getUsername());
        memberRepository.save(member);

        return member.getId();
    }

    @Override
    public Long updateMemberPassword(MemberPasswordUpdateDTO memberPasswordUpdateDTO, String phone) {
        Member member = memberRepository.findByPhone(phone).orElseThrow(() -> new UsernameNotFoundException("전화번호가 존재하지 않습니다."));

        if (!passwordEncoder.matches(memberPasswordUpdateDTO.getCurrentPassword(), member.getPassword())) {
            return null;
        } else {
            memberPasswordUpdateDTO.setNewPassword(passwordEncoder.encode(memberPasswordUpdateDTO.getNewPassword()));
            member.updatePassword(memberPasswordUpdateDTO.getNewPassword());
            memberRepository.save(member);
        }

        return member.getId();
    }

    @Override
    public boolean withdrawal(String phone, String password) {
        Member member = memberRepository.findByPhone(phone).orElseThrow(() -> new UsernameNotFoundException("전화번호가 존재하지 않습니다."));

        if (passwordEncoder.matches(password, member.getPassword())) {
            memberRepository.delete(member);
            return true;
        } else {
            return false;
        }
    }
}