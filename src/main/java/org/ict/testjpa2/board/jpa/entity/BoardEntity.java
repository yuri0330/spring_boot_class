package org.ict.testjpa2.board.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ict.testjpa2.board.model.dto.BoardDto;

import java.util.Date;
import java.util.GregorianCalendar;

// 테이블 생성에 대한 가이드 클래스임
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="BOARD")
@Entity //jpa가 관리를 하고 repository 와 자동연결 됨
public class BoardEntity {

    //jpa 가 객체를 관리 할때 식별할 기본키 저장
    //@GeneratedValue(strategy = GenerationType.IDENTITY) //primary key 지정
    // 사용하면 무조건 default 로 입려되므로 주석 처리할 것
    @Id
    @Column(name="BOARD_NUM",nullable=false)
    private int boardNum;
    @Column(name="BOARD_WRITER",nullable=false, length=50)
    private String boardWriter;
    @Column(name="BOARD_TITLE", nullable=false, length=50)
    private String boardTitle;
    @Column(name="BOARD_CONTENT", nullable=false, length=2000)
    private String boardContent;
    @Column(name="BOARD_ORIGINAL_FILENAME")
    private String boardOriginalFilename;
    @Column(name="BOARD_RENAME_FILENAME")
    private String boardRenameFilename;
    @Column(name="BOARD_READCOUNT")
    private int boardReadCount;
    @Column(name = "BOARD_DATE")
    private Date boardDate;

    @PrePersist //jpa 로 가기전에 작동됨
    public void prePersist() {
        //boardDate 에 현제 날짜 적용
        boardDate = new GregorianCalendar().getGregorianChange();
    }


    //Entity -->dto  로 변환하는 메소드
    public BoardDto todato() {
        return BoardDto.builder()
                .boardNum(this.boardNum)
                .boardWriter(this.boardWriter)
                .boardTitle(this.boardTitle)
                .boardContent(this.boardContent)
                .boardOriginalFilename(this.boardOriginalFilename)
                .boardRenameFilename(this.boardRenameFilename)
                .boardReaCount(this.boardReadCount)
                .boardDate(this.boardDate)
                .build();
    }
    public BoardDto toDatoTop3() {
        return BoardDto.builder()
                .boardNum(this.boardNum)
                .boardTitle(this.boardTitle)
                .boardReaCount(this.boardReadCount)
                .build();
    }


}

