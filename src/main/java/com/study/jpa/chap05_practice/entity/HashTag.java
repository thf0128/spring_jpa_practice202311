package com.study.jpa.chap05_practice.entity;

import lombok.*;

import javax.persistence.*;

@Setter @Getter
@ToString(exclude = {"post"})
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_hash_tag")
public class HashTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_no")
    private Long id;

    private String tagName; // 해시태그 이름

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //cascade 폭포수 처럼 낙하 부모에서 낙하해서 자식에게 영향을 주겠다.
    @JoinColumn(name = "post_no")
    private Post post;

}


