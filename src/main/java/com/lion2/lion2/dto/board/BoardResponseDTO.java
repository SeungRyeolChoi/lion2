package com.lion2.lion2.dto.board;

import com.lion2.lion2.domain.Board;
import com.lion2.lion2.domain.BoardImage;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class BoardResponseDTO {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private String username;
    private String phone;
    private List<String> imageUrls;

    @Builder
    public BoardResponseDTO(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.createdAt = board.getCreatedAt();
        this.username = board.getMember().getUsername();
        this.phone = board.getMember().getPhone();
        this.imageUrls = board.getBoardImages().stream()
                .map(BoardImage::getUrl)
                .collect(Collectors.toList());
    }
}