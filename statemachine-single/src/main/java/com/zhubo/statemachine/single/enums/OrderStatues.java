package com.zhubo.statemachine.single.enums;

/**
 * <p>Company: 成都返空汇网络技术有限公司</p>
 * <p>Description:  </p>
 *
 * @author zhubo
 * @version 1.0
 * @email "mailto:https://github.com/CD-ZHUBO"
 * @date 2020.08.04 18:11
 * @since 1.0
 */
public enum  OrderStatues {
    /** 待支付 */
    WAIT_PAYMENT,
    /** 待发货 */
    WAIT_DELIVER,
    /** 待收货 */
    WAIT_RECEIVE,
    /** 订单结束 */
    FINISH;

    public static String name(OrderStatues orderStatues) {
        return orderStatues.name();
    }
}
