package com.study.jpa.chap05_practice.dto;

import com.study.jpa.chap05_practice.entity.Post;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Setter @Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostCreateDTO {

    // @NotNull -> null을 허용하지 않음. "", " "은 허용
    // @NotEmpty -> null, ""을 허용하지 않음. " "은 허용
    @NotBlank // null, "", " " 모두를 허용하지 않음
    @Size(min = 2, max = 5)
    private String writer;

    @NotBlank
    @Size(min = 1, max = 20)
    private String title;

    private String content;

    private List<String> hashTags;
    
    //class로 박아놓으면 한줄로 처리가능 생성자보다는 메서드로 처리 리턴해주어야 하니 생성자는 return기능 없으니
    // dto를 엔터티로 변환하는 메서드
    public Post toEntity() {
        //controller에서 dto를 엔터티로 변환해서 넘겨주는 toEntity entity받는 이유는 PostRepository안에 <Post, Long>선언해서
        return Post.builder()
                .writer(this.writer)
                .content(this.content)
                .title(this.title)
                // 해시태그는 못 넣음 조회할때 넣는것 테이블의 해시태그라는 컬럼자체가 존재하지 않음 객체 타입이 달라 불가능
                .build();
    }

}















