package com.lion2.lion2.dto.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardWriteRequestDTO {

    private String title;
    private String content;
}