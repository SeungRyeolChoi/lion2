package com.lion2.lion2.repository;

import com.lion2.lion2.domain.Image;
import com.lion2.lion2.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {

    Image findByMember(Member member);
}