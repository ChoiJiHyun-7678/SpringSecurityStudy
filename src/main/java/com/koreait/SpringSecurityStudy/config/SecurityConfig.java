package com.koreait.SpringSecurityStudy.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

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


        // 요청을 URL 에 대한  CORS 설정을 적용을 위해 객체
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        //모든 URL("/**")에 대한 정책을 허용한다.
        source.registerCorsConfiguration("/**",corsConfiguration);
        return source;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors(Customizer.withDefaults());

    }

}
