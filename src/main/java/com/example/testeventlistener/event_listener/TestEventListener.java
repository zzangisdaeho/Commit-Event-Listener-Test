package com.example.testeventlistener.event_listener;

import com.example.testeventlistener.service.SubTestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Slf4j
@RequiredArgsConstructor
public class TestEventListener {

    private final SubTestService subTestService;

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
//    @EventListener
    public void testListener(TestDto testDto){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("logging dto seq: {}", testDto.getSeq());

        subTestService.subService(testDto.getSeq());
    }
}
