package org.ict.testjpa2.notice.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ict.testjpa2.notice.model.dto.NoticeDto;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="NOTICE")
@Entity //jpa가 관리를 하고 repository 와 자동연결 됨
public class NoticeEntity {

    @Id
    @Column(name = "NOTICENO")
    private Long noticeNo;

    @Column(name = "NOTICETITLE", length = 50)
    private String noticeTitle;

    @Column(name = "NOTICEDATE")
    private Date noticeDate;

    @Column(name = "NOTICEWRITER", length = 50)
    private String noticeWriter;

    @Column(name = "NOTICECONTENT", length = 2000)
    private String noticeContent;

    @Column(name = "ORIGINAL_FILEPATH", length = 100)
    private String originalFilePath;

    @Column(name = "RENAME_FILEPATH", length = 100)
    private String renameFilePath;

    @Column(name = "IMPORTANCE", length = 1)
    private char importance;

    @Column(name = "IMP_END_DATE")
    private Date impEndDate;

    @Column(name = "READCOUNT")
    private int readCount;

    // Entity를 DTO로 변환하는 메소드
    public NoticeDto toDto() {
        return NoticeDto.builder()
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
