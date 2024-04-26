package org.ict.testjpa2.notice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ict.testjpa2.notice.jpa.entity.NoticeEntity;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data   //@ToString,@EqualsAndHashCode, @Getter,@Setter,@RequireArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component //일반 클래스로 설정할 때 사용
public class NoticeDto {
    private Long noticeNo;
    private String noticeTitle;
    private Date noticeDate;
    private String noticeWriter;
    private String noticeContent;
    private String originalFilePath;
    private String renameFilePath;
    private char importance;
    private Date impEndDate;
    private int readCount;

    // DTO를 엔티티로 변환하는 메소드
    public NoticeEntity toEntity() {
        return NoticeEntity.builder()
                .noticeNo(this.noticeNo)
                .noticeTitle(this.noticeTitle)
                .noticeDate(this.noticeDate)
                .noticeWriter(this.noticeWriter)
                .noticeContent(this.noticeContent)
                .originalFilePath(this.originalFilePath)
                .renameFilePath(this.renameFilePath)
                .importance(this.importance)
                .impEndDate(this.impEndDate)
                .readCount(this.readCount)
                .build();
    }

}
