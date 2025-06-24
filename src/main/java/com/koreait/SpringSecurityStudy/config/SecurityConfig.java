package com.koreait.SpringSecurityStudy.config;


import com.koreait.SpringSecurityStudy.security.filter.JwtAuthenticationFilter;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    // 기본적으로 브라우저는 같은 출처만 허용한다.
    // 브라우저가 보안상 다른 도메인의 리소스 요청을 제한하는 정책
    // = CORS보안정책
    @Bean
    public CorsConfigurationSource configurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //요청을 보내는 쪽의 도메인을 허용시키겠다.
        corsConfiguration.addAllowedOriginPattern(CorsConfiguration.ALL);
        //요청을 보내는 쪽에서 특정 정보에대한 제약을 허용
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL);
        // 요청을 보내는 쪽의 메소드
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL);


        source.registerCorsConfiguration("/**",corsConfiguration);
        return source;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors(Customizer.withDefaults());
        http.cors(csrf -> csrf.disable());
        // 사용자가 의도하지 않은 요청을 공격자가 서버에 전달하도록 하는 공격(해킹=공격)
        // 세션이 없고, 쿠키도 안쓰고, 토튼 기반이기때문
        // 서버사이드 렌더링 로그인 방식 비활성화
        http.formLogin(formLogin -> formLogin.disable());
        http.httpBasic(httpBasic -> httpBasic.disable());
        // 서버 사이드 방식 로그인 방식 비활성화
        http.logout(logout -> logout.disable());
        http.sessionManagement(        // 요청을 URL 에 대한  CORS 설정을 적용을 위해 객체
                UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        //모든 URL("/**")에 대한 정책을 허용한다.
        Session -> Session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        //특정 요청에 대한 권한 설정
        http.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/auth/test").permitAll();
            auth.anyRequest().authenticated();
        });
        return http.build();
        //인증 컽레스트에 인증 객체 저장 -> 인증 실패든 성공이든 필터링을 중단하지 않고 다음 플터로 넘어감
    }
}
