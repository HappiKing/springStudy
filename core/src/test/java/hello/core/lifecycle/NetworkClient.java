package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

// 1. InitializingBean, DisposableBean : 인터페이스를 사용하는 초기화, 종료 방법은 초창기 방식, 요즘은 거의 사용하지 않는다.
// 2. 설정 정보에 @Bean(initialMethod = "init", destroyMethod = "close")를 사용
// 3. Annotation을 활용한 @PostConstruct, @PreDestroy 사용 *추천*
//public class NetworkClient implements InitializingBean, DisposableBean {
public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출 url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작 시 호출
    public void connect() {
        System.out.println("connect = " + url);
    }

    public void call(String message) {
        System.out.println("call = " + url + " message = " + message);
    }

    // 서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close = " + url);
    }

//    // 1. 예전 방식
//    // 의존 관계 주입이 끝나면 호출할 코드 작성
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("NetworkClient.afterPropertiesSet");
//        connect();
//        call("초기화 연결 메시지");
//    }
//
//    // 의존 관계 주입이 끝나면 호출할 코드 작성
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("NetworkClient.destroy");
//        disconnect();
//    }

//    // 2. 빈 등록 초기화, 소멸 메서드 지정
//    // 의존 관계 주입이 끝나면 호출할 코드 작성
//    public void init() {
//        System.out.println("NetworkClient.afterPropertiesSet");
//        connect();
//        call("초기화 연결 메시지");
//    }
//
//    // 의존 관계 주입이 끝나면 호출할 코드 작성
//    public void close() {
//        System.out.println("NetworkClient.destroy");
//        disconnect();
//    }

    // 3. Annotation을 활용한 @PostConstruct, @PreDestroy 사용 **추천**
    // 의존 관계 주입이 끝나면 호출할 코드 작성
    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }

    // 의존 관계 주입이 끝나면 호출할 코드 작성
    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.destroy");
        disconnect();
    }


}
