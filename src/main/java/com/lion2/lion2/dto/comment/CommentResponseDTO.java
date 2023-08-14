package com.lion2.lion2.dto.comment;

import com.lion2.lion2.domain.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentResponseDTO {

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long id;
    private String content;
    private String username;
    private String phone;
    private String imageUrl;

    @Builder
    public CommentResponseDTO(Comment comment) {
        this.createdAt = comment.getCreatedAt();
        this.updatedAt = comment.getUpdatedAt();
        this.id = comment.getId();
        this.content = comment.getContent();
        this.username = comment.getMember().getUsername();
        this.phone = comment.getMember().getPhone();
        this.imageUrl = comment.getMember().getImage().getUrl();
    }
}