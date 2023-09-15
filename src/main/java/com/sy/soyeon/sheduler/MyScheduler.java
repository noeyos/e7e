package com.sy.soyeon.sheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MyScheduler {

//    @Scheduled(fixedDelay = 3000) // 3초마다
//    public void schdlr1() {
//        log.debug("뿅");
//    }

//    @Scheduled(cron = "10 36 * * * *")
//    // cron = "* * * * * * " ==> 초 / 분 / 시간 / 일 / 월 / 요일
//    public void schdlr2() {
//        log.debug("먀");
//    }
}
