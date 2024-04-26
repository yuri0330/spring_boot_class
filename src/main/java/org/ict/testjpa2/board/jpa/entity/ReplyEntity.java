package org.ict.testjpa2.board.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ict.testjpa2.board.model.dto.BoardDto;
import org.ict.testjpa2.board.model.dto.ReplyDto;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="REPLY")
@Entity //jpa가 관리를 하고 repository 와 자동연결 됨
public class ReplyEntity {
    @Id
    @Column(name = "REPLY_NUM")
    private Long replyNum;

    @Column(name = "REPLY_WRITER", length = 50)
    private String replyWriter;

    @Column(name = "REPLY_TITLE", length = 50)
    private String replyTitle;

    @Column(name = "REPLY_CONTENT", length = 2000)
    private String replyContent;

    @Column(name = "BOARD_REF")
    private Long boardRef;

    @Column(name = "REPLY_REPLY_REF")
    private Long replyReplyRef;

    @Column(name = "REPLY_LEV")
    private Long replyLev;

    @Column(name = "REPLY_SEQ")
    private Long replySeq;

    @Column(name = "REPLY_READCOUNT")
    private Long replyReadCount;

    @Column(name = "REPLY_DATE")
    private Date replyDate;

    //Entity -->dto  로 변환하는 메소드
   public ReplyDto toDto() {
       return ReplyDto.builder()
               .replyNum(this.replyNum)
               .replyWriter(this.replyWriter)
               .replyTitle(this.replyTitle)
               .replyContent(this.replyContent)
               .boardRef(this.boardRef)
               .replyReplyRef(this.replyReplyRef)
               .replyLev(this.replyLev)
               .replySeq(this.replySeq)
               .replyReadCount(this.replyReadCount)
               .replyDate(this.replyDate)
               .build();
   }
}
