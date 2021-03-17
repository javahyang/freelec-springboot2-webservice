package com.jojoldu.book.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration // @WebMvcTest 는 일반적인 @Configuration 스캔하지 않음
@EnableJpaAuditing // JPA Auditing 활성화
public class JpaConfig {
}
