package racingcar.study.staticfactory.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.study.staticfactory.example.Coupon;
import racingcar.study.staticfactory.example.Discount;
import racingcar.study.staticfactory.example.OrderUtil;
import racingcar.study.staticfactory.example.Point;

/**
 * 3.하위 자료형 객체를 반환할 수 있다
 */
public class OrderUtilTest {
    @Test
    void createCouponItem() throws Exception {
        Discount coupon = OrderUtil.createDiscountItem("coupon");
        boolean actual = coupon instanceof Coupon;
        Assertions.assertThat(actual).isTrue();
    }

    @Test
    void createPointItem() throws Exception {
        Discount point = OrderUtil.createDiscountItem("point");
        boolean actual = point instanceof Point;
        Assertions.assertThat(actual).isTrue();
    }
}
