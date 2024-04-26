package org.ict.testjpa2.board.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ict.testjpa2.board.jpa.entity.ReplyEntity;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data   //ToString,@EqualsAndHashCode, @Getter,@Setter,@RequireArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component //일반 클래스로 설정할 때 사용
public class ReplyDto {
    //프로퍼티(property, == 멤버변수, field)
    private Long replyNum;
    private String replyWriter;
    private String replyTitle;
    private String replyContent;
    private Long boardRef;
    private Long replyReplyRef;
    private Long replyLev;
    private Long replySeq;
    private Long replyReadCount;
    private Date replyDate;

    public ReplyEntity toEntity() {
        return ReplyEntity.builder()
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
