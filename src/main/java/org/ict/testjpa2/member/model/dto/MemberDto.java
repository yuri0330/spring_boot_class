package org.ict.testjpa2.member.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ict.testjpa2.member.jpa.entity.MemberEntity;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class MemberDto {

    //프로퍼티(property, == 멤버변수, field)

    private String userId;
    private String userPwd;
    private String userName;
    private String gender;
    private int age;
    private String phone;
    private String email;
    private Date enrollDate;
    private Date lastModified;
    private String signType;
    private char adminYn;
    private char loginOk;
    private String photoFilename;

    // DTO를 엔티티로 변환하는 메소드
    public MemberEntity toEntity() {
        return MemberEntity.builder()
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
