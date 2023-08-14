package com.lion2.lion2.repository;


import com.lion2.lion2.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

//    /**
//     * 전화번호로 회원 찾기
//     * @param phone 회원 저노하번호
//     * @return 회원 정보
//     */
    Optional<Member> findByPhone(String phone);

//    /**
//     * 유효성 검사 - 중복 체크
//     * @param phone 회원 전화번호
//     * @return 참/거짓
//     */
    boolean existsByPhone(String phone);
}