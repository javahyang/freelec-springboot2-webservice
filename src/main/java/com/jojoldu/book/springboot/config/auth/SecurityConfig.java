package com.jojoldu.book.springboot.config.auth;

import com.jojoldu.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // SpringSecurity 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable().headers().frameOptions().disable() // h2-console 화면 사용하기위해 옵션 disable
            .and()
                .authorizeRequests() // URL 별 권한관리 설정 옵션의 시작점
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll() // 전체 열람 권한
                .antMatchers("/api/v1/**").hasRole(Role.USER.name()) // USER 권한 가진 사람만 가능
                .anyRequest().authenticated() // 설정된 값 이외 나머지 URL 들에 인증용(로그인)된 사용자만 허
            .and()
                .logout().logoutSuccessUrl("/") // 로그아웃이 성공하면 루트로 이동
            .and()
                .oauth2Login() // OAuth2 로그인 기능에 대한 여러 설정의 진입점
                    .userInfoEndpoint() // 로그인 성공 후 사용자 정보 가져올 때 설정
                        .userService(customOAuth2UserService); // 로그인 성공 후 후속조치
    }
}
