package com.study.jpa.chap04_relation.entity;

import lombok.*;

import javax.persistence.*;

@Setter @Getter
// jpa 연관관계 매핑에서 연관관계 데이터는 toString에서 제외해야 합니다.
@ToString(exclude = {"department"})
@EqualsAndHashCode(of = "id") // id가 같으면 같은 객체다
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_emp")
public class Employee {

    @Id //primary key라는 소리
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long id;

    @Column(name = "emp_name", nullable = false)
    private String name;

    // EAGER: 항상 무조건 조인을 수행
    // LAZY: 필요한 경우에만 조인을 수헹. (실무)
    @ManyToOne(fetch = FetchType.LAZY) // 안 필요하면 JOIN 진행되지 않음
    @JoinColumn(name = "dept_id")
    private Department department;

}
