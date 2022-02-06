package com.filterdemo.controller;

import com.filterdemo.dto.RpBoardListDto;
import com.filterdemo.dto.RqBoardListSearchDto;
import com.filterdemo.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;


    @GetMapping("/board")
    public ResponseEntity<RpBoardListDto> getBoardList(RqBoardListSearchDto dto) {
        log.info(dto.toString());
        return boardService.getBoardList(dto);
    }
}
