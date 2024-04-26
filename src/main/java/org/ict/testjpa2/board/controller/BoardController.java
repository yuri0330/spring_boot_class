package org.ict.testjpa2.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.testjpa2.board.model.dto.BoardDto;
import org.ict.testjpa2.board.model.sevice.BoardService;
import org.ict.testjpa2.board.model.sevice.ReplyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
@CrossOrigin    //리액트 어플리케이션(포트가 다름)의 자원 요청을 처리하기 위함
public class BoardController {
    private final BoardService boardservice;
    private final ReplyService replyservice;

    @GetMapping("/btop3")
    public ResponseEntity<List<BoardDto>> selectTop3(){
        log.info("/boards/btop3 => selectTop3()");
        return new ResponseEntity<>(boardservice.selectTop3(), HttpStatus.OK);
    }





}
