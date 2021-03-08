package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 주민번호, 복합키 등은 유니크 키로 별도추가할 것. PK는 Long 타입의 Auto_increment 추천

    // @Column 어노테이션 : 기본값 외에 추가로 변경이 필요한 옵션있을 때 사용
    @Column(length = 500, nullable = false)
    private String title;

    // TEXT 로 타입변경
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    // 생성 시점에 값을 채우는 역할(생성자 또는 빌더)
    // 생성자는 지금 채워야 할 필드가 무엇인지 명확히 지정할 수 없다
    // 빌더는 어느 필드에 어떤 값을 채워야 할지 명확하게 인지할 수 있다
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // Entity 클래스에는 절대 Setter 메소드 만들지 않는다.
    // 해당 필드의 값 변경이 필요하면 그 목적과 의도를 알 수 있는 메소드를 추가한다.
}
