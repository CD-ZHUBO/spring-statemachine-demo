package com.zhubo.statemachine.single;

import com.zhubo.statemachine.enums.OrderStatues;
import com.zhubo.statemachine.enums.OrderStatusChangeEvent;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

import javax.annotation.Resource;

/**
 * <p>Company: 成都返空汇网络技术有限公司</p>
 * <p>Description:  </p>
 *
 * @author zhubo
 * @version 1.0
 * @email "mailto:https://github.com/CD-ZHUBO"
 * @date 2020.08.04 11:45
 * @since 1.0
 */
@SpringBootApplication
public class StateMachineSingleApplication implements CommandLineRunner {
    /** State machine */
    @Resource
    StateMachine<OrderStatues, OrderStatusChangeEvent> stateMachine;

    /**
     * Main
     *
     * @param args args
     * @since 1.0
     */
    public static void main(String[] args) {
        SpringApplication.run(StateMachineSingleApplication.class);
    }

    public void run(String... args) throws Exception {
        stateMachine.start();
        Thread.sleep(3000L);
        stateMachine.sendEvent(OrderStatusChangeEvent.PAYED);
    }
}
