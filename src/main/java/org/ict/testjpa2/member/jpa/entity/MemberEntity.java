package org.ict.testjpa2.member.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ict.testjpa2.member.model.dto.MemberDto;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="MEMBER")
@Entity //jpa가 관리를 하고 repository 와 자동연결 됨
public class MemberEntity {

    @Id
    @Column(name="USERID", length = 50)
    private String userId;

    @Column(name="USERPWD", length = 100)
    private String userPwd;

    @Column(name="USERNAME", length = 20)
    private String userName;

    @Column(name="GENDER", length = 1)
    private String gender;

    @Column(name="AGE")
    private int age;

    @Column(name="PHONE", length = 13)
    private String phone;

    @Column(name="EMAIL", length = 30)
    private String email;

    @Column(name="ENROLL_DATE")
    private Date enrollDate;

    @Column(name="LASTMODIFIED")
    private Date lastModified;

    @Column(name="SIGNTYPE", length = 10)
    private String signType;

    @Column(name="ADMIN_YN", length = 1)
    private char adminYn;

    @Column(name="LOGIN_OK", length = 1)
    private char loginOk;

    @Column(name= "PHOTO_FILENAME", length = 100)
    private String photoFilename;

    // Entity를 DTO로 변환하는 메소드
    public MemberDto toDto() {
        return MemberDto.builder()
                .userId(this.userId)
                .userPwd(this.userPwd)
                .userName(this.userName)
                .gender(this.gender)
                .age(this.age)
                .phone(this.phone)
                .email(this.email)
                .enrollDate(this.enrollDate)
                .lastModified(this.lastModified)
                .signType(this.signType)
                .adminYn(this.adminYn)
                .loginOk(this.loginOk)
                .photoFilename(this.photoFilename)
                .build();
    }
}
