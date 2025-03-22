package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor // final이 붙은 것들에 대한 생성자를 만들어준다.
public class OrderServiceImpl implements OrderService {

//    @Autowired private MemberRepository memberRepository; // 필드에 바로 주입, 외부에서 변경이 불가능해서 테스트 하기 힘들다는 치명적인 단점.
//    @Autowired private DiscountPolicy discountPolicy;

    private final MemberRepository memberRepository; // 얘는 추상적으로 어떤 구현이 될 지 모른다.
    private final DiscountPolicy discountPolicy;

//    @Autowired(required = false) // Default는 주입할 대상이 없으면 오류가 발생한다. required를 false로 설정하면 주입할 대상이 없어도 동작한다.
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }

////    @Autowired // 생성자 위에 AutoWired 추가, 생성자가 하나만 있으면 생략 가능.
//      Lombok의 @RequiredArgsConstructor를 사용하면 생성자를 어노테이션이 직접 만들어준다.
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // Test용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
