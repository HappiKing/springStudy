# SpringStudy

2025.03.10(비즈니스 요구사항과 설계)
- enum : 미리 정의된 상수들의 특별한 집합, enum(enumeration) 의 뜻을 열거, 대문자로 적는 것을 원칙

1. enum을 만들었다.
2. 엔티티를 만들었다.
3. 인터페이스를 만들었다.(MemberRepository)
4. 구현체를 만들었다.(MemoryMemberRepository), 구현체에서 재정의 @Override(저장, 조회 기능 구현)
5. 인터페이스를 만들었다. (MemberService)
6. 구현체를 만들었다. (MemberServiceImpl)

-> 문제점 : 추상화 구체화 둘 다 의존적이다.
