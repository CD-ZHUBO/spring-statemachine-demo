package com.zhubo.statemachine.single.enums;

/**
 * <p>Company: 成都返空汇网络技术有限公司</p>
 * <p>Description:  </p>
 *
 * @author zhubo
 * @version 1.0
 * @email "mailto:https://github.com/CD-ZHUBO"
 * @date 2020.08.04 18:12
 * @since 1.0
 */
public enum OrderStatusChangeEvent {
    /** 支付 */
    PAYED,
    /** 发货 */
    DELIVERY,
    /** 确认收货 */
    RECEIVED;
}
