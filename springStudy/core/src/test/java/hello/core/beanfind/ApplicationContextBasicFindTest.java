package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext AppConfig = new AnnotationConfigApplicationContext(hello.core.AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = AppConfig.getBean("memberService", MemberService.class);
        System.out.println("memberService = " + memberService );
        System.out.println("memberService.getClass() = " + memberService.getClass());

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로 조회")
    void findBeanByType() {
        MemberService memberService = AppConfig.getBean(MemberService.class);
        System.out.println("memberService = " + memberService );
        System.out.println("memberService.getClass() = " + memberService.getClass());

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        MemberServiceImpl memberServiceImpl = AppConfig.getBean("memberService", MemberServiceImpl.class);
        System.out.println("memberService = " + memberServiceImpl );
        System.out.println("memberService.getClass() = " + memberServiceImpl.getClass());

        Assertions.assertThat(memberServiceImpl).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByName_X () {
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> AppConfig.getBean("xxxx", MemberService.class));

    }
}
