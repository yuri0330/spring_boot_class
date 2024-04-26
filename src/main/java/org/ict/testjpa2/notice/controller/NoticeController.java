package org.ict.testjpa2.notice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.testjpa2.notice.model.service.NoticeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/notices")
@RequiredArgsConstructor
@CrossOrigin    //리액트 어플리케이션(포트가 다름)의 자원 요청을 처리하기 위함
public class NoticeController {
    private NoticeService noticeservice;
}
