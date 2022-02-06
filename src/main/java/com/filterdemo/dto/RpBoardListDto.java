package com.filterdemo.dto;

import com.filterdemo.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class RpBoardListDto {

    private List<BoardListDto> boardListDtoList = new ArrayList<>();

    @Builder
    public RpBoardListDto(List<Board> boardList) {
        this.boardListDtoList = boardList.stream()
                .map(BoardListDto::new).collect(Collectors.toList());
    }
}
