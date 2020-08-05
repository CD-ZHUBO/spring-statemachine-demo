package com.zhubo.statemachine.single.listener;

import com.zhubo.statemachine.single.enums.OrderStatusChangeEvent;

import org.springframework.messaging.Message;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>Company: 成都返空汇网络技术有限公司</p>
 * <p>Description:  </p>
 *
 * @author zhubo
 * @version 1.0
 * @email "mailto:https://github.com/CD-ZHUBO"
 * @date 2020.08.04 18:26
 * @since 1.0
 */
@Slf4j
@Component
@WithStateMachine
public class StateMachineSingleListener {


    /**
     * 付款
     *
     * @return the boolean
     * @since 1.0
     */
    @OnTransition(target = "WAIT_DELIVER")
    public boolean pay(Message<OrderStatusChangeEvent> message) {
        log.warn("付款状态");
        return true;
    }

    /**
     * 发货
     *
     * @param message message
     * @return the boolean
     * @since 1.0
     */
    @OnTransition(target = "WAIT_RECEIVE")
    public boolean deliverTransition(Message<OrderStatusChangeEvent> message) {
        log.warn("发货状态");
        return true;
    }

    /**
     * 收货
     *
     * @param message message
     * @return the boolean
     * @since 1.0
     */
    @OnTransition(target = "FINISH")
    public boolean receiveTransition(Message<OrderStatusChangeEvent> message){
        log.warn("收货状态");
        return true;
    }
}
