package hello.core.member;


import hello.core.AppConfig;
import hello.core.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();

        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        // given : ~ 환경이 주어졌을 때
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when : 이렇게 했을 때
        memberService.join(member);
        Member findMember = memberService.findMemberById(member.getId());

        // then : 이렇게 된다.
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}
