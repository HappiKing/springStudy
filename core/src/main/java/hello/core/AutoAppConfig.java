package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = {"hello.core"},
        basePackageClasses = {AutoAppConfig.class}, // default는 @Component가 붙은 설정 정보 클래스의 패키지가 시작 위치가 된다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Configuration.class}) // 자동스캔 대상에서 제거, AppConfig랑 충동을 방지
)
public class AutoAppConfig {

}
