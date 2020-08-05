package com.zhubo.statemachine.single.config;

import com.zhubo.statemachine.enums.OrderStatues;
import com.zhubo.statemachine.enums.OrderStatusChangeEvent;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>Company: 成都返空汇网络技术有限公司</p>
 * <p>Description:  </p>
 *
 * @author zhubo
 * @version 1.0
 * @email "mailto:https://github.com/CD-ZHUBO"
 * @date 2020.08.04 18:10
 * @since 1.0
 */
@Slf4j
@Configuration
@EnableStateMachine
public class StateMachineSingleConfiguration extends StateMachineConfigurerAdapter<OrderStatues, OrderStatusChangeEvent> {
    /**
     * 配置状态
     *
     * @param states @see OrderStatues
     * @throws Exception exception
     */
    @Override
    public void configure(StateMachineStateConfigurer<OrderStatues, OrderStatusChangeEvent> states) throws Exception {
        states
            .withStates()
            // 初始化状态
            .initial(OrderStatues.WAIT_PAYMENT)
            // 设置状态所有值
            .states(EnumSet.allOf(OrderStatues.class));
    }

    /**
     * 配置状态转换事件关系
     *
     * @param transitions 状态转换
     * @throws Exception exception
     */
    @Override
    public void configure(StateMachineTransitionConfigurer<OrderStatues, OrderStatusChangeEvent> transitions) throws Exception {
        transitions.withExternal()
            .source(OrderStatues.WAIT_PAYMENT).target(OrderStatues.WAIT_DELIVER).event(OrderStatusChangeEvent.PAYED)
            .and().withExternal()
            .source(OrderStatues.WAIT_DELIVER).target(OrderStatues.WAIT_RECEIVE).event(OrderStatusChangeEvent.DELIVERY)
            .and().withExternal()
            .source(OrderStatues.WAIT_RECEIVE).target(OrderStatues.FINISH).event(OrderStatusChangeEvent.RECEIVED);
    }

    // 可以通过如下方式配置，并在对应方法中做相关业务逻辑
    // 另外一种方式可以参考：StateMachineSingleListener 的处理
    // @Override
    // public void configure(StateMachineConfigurationConfigurer<OrderStatues, OrderStatusChangeEvent> config) throws Exception {
    //     config
    //         .withConfiguration()
    //         .listener(new StateMachineListenerAdapter<OrderStatues, OrderStatusChangeEvent>() {
    //             @Override
    //             public void stateChanged(State<OrderStatues, OrderStatusChangeEvent> from, State<OrderStatues, OrderStatusChangeEvent> to) {
    //                 log.warn("stateChanged");
    //                 super.stateChanged(from, to);
    //             }
    //
    //             @Override
    //             public void stateEntered(State<OrderStatues, OrderStatusChangeEvent> state) {
    //                 log.warn("stateEntered");
    //                 super.stateEntered(state);
    //             }
    //
    //             @Override
    //             public void stateExited(State<OrderStatues, OrderStatusChangeEvent> state) {
    //                 log.warn("stateExited");
    //                 super.stateExited(state);
    //             }
    //
    //             @Override
    //             public void eventNotAccepted(Message<OrderStatusChangeEvent> event) {
    //                 log.warn("eventNotAccepted");
    //                 super.eventNotAccepted(event);
    //             }
    //
    //             @Override
    //             public void transition(Transition<OrderStatues, OrderStatusChangeEvent> transition) {
    //                 log.warn("transition");
    //                 super.transition(transition);
    //             }
    //
    //             @Override
    //             public void transitionStarted(Transition<OrderStatues, OrderStatusChangeEvent> transition) {
    //                 log.warn("transition started");
    //                 super.transitionStarted(transition);
    //             }
    //
    //             @Override
    //             public void transitionEnded(Transition<OrderStatues, OrderStatusChangeEvent> transition) {
    //                 log.warn("transition ended");
    //                 super.transitionEnded(transition);
    //             }
    //
    //             @Override
    //             public void stateMachineStarted(StateMachine<OrderStatues, OrderStatusChangeEvent> stateMachine) {
    //                 log.warn("state machine started");
    //                 super.stateMachineStarted(stateMachine);
    //             }
    //
    //             @Override
    //             public void stateMachineStopped(StateMachine<OrderStatues, OrderStatusChangeEvent> stateMachine) {
    //                 log.warn("state machine stopped");
    //                 super.stateMachineStopped(stateMachine);
    //             }
    //
    //             @Override
    //             public void stateMachineError(StateMachine<OrderStatues, OrderStatusChangeEvent> stateMachine, Exception exception) {
    //                 log.warn("state machine error");
    //                 super.stateMachineError(stateMachine, exception);
    //             }
    //
    //             @Override
    //             public void extendedStateChanged(Object key, Object value) {
    //                 log.warn("extended state changed");
    //                 super.extendedStateChanged(key, value);
    //             }
    //
    //             @Override
    //             public void stateContext(StateContext<OrderStatues, OrderStatusChangeEvent> stateContext) {
    //                 log.warn("state context");
    //                 super.stateContext(stateContext);
    //             }
    //         });
    // }
}
