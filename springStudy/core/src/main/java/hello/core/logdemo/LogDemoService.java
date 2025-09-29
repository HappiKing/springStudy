package hello.core.logdemo;

import hello.core.common.MyLogger;
import jakarta.inject.Provider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final Provider<MyLogger> provider;

    public void logic(String id) {
        MyLogger myLogger = provider.get();
        myLogger.log("service ID = " + id);
    }
}
