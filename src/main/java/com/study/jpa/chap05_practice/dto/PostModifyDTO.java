package com.study.jpa.chap05_practice.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter @Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostModifyDTO {

    //한번더 검증
    @NotBlank
    @Size(min = 1, max = 20)
    private String title;


    private String content;

    @NotNull // 공백이나 빈 문자열이 들어올 수 없는 타입은 NotNull로 선언.
    @Builder.Default // 직접 초기화 강제로 값 넣어줌
    private Long postNo = 0L; // @Builder.Default 없이 noarg사용하면 null들어올수도 있음

}
