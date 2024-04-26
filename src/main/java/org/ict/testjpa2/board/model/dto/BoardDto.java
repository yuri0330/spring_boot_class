package org.ict.testjpa2.board.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.*;
import org.ict.testjpa2.board.jpa.entity.BoardEntity;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data   //ToString,@EqualsAndHashCode, @Getter,@Setter,@RequireArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component //일반 클래스로 설정할 때 사용
public class BoardDto {
    // 게시글 원글
    //프로퍼티(property, == 멤버변수, field)
    private int boardNum;
    private String boardWriter;
    private String boardTitle;
    private String boardContent;
    private String boardOriginalFilename;
    private String boardRenameFilename;
    private int boardReaCount;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date boardDate;

    //dto --> Entity 로 변환하는 메소드
    public BoardEntity toEntity(){
        return BoardEntity.builder()
                .boardNum(this.boardNum)
                .boardWriter(this.boardWriter)
                .boardTitle(this.boardTitle)
                .boardContent(this.boardContent)
                .boardOriginalFilename(this.boardOriginalFilename)
                .boardRenameFilename(this.boardRenameFilename)
                .boardReadCount(this.boardReaCount)
                .boardDate(this.boardDate)
                .build();

    }
}
