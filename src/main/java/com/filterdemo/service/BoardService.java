package com.filterdemo.service;

import com.filterdemo.dto.RpBoardListDto;
import com.filterdemo.dto.RqBoardListSearchDto;
import com.filterdemo.entity.Board;
import com.filterdemo.repository.BoardQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardQueryRepository boardQueryRepository;

    public ResponseEntity<RpBoardListDto> getBoardList(RqBoardListSearchDto dto) {

        List<Board> boardList = boardQueryRepository.getBoardList(dto);

        return new ResponseEntity<>(RpBoardListDto.builder()
                .boardList(boardList)
                .build(), HttpStatus.OK);
    }
}
