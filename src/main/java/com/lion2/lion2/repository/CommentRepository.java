package com.lion2.lion2.repository;

import com.lion2.lion2.domain.Board;
import com.lion2.lion2.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

//    /**
//     * Board로 Comment 조회
//     * @param board 게시물 정보
//     * @return 댓글 리스트
//     */
    List<Comment> findByBoard(Board board);
}