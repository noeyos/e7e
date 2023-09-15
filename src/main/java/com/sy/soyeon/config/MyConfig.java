package com.sy.soyeon.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration      // 스프링이 알아서 이 클래스 파일을 설정 파일로 인식하게 함
                    // root-context에서 annotation-config
@EnableScheduling   // 기본 제공 스케줄러 사용하겠다
public class MyConfig {


}
