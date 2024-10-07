package race;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarRandomMoveRuleTest {
    @Test
    void checkMove_랜덤값이_4이면_true를_반환한다() {
        CarMoveRule carRandomMoveRule = CarRandomMoveRule.create();
        CarMoveRuleValue carRandomMoveRuleValue = new MockCarRandomMoveRuleValue(4);

        assertThat(carRandomMoveRule.check(carRandomMoveRuleValue)).isTrue();
    }

    @Test
    void checkMove_랜덤값이_4이상이면_true를_반환한다() {
        CarMoveRule carRandomMoveRule = CarRandomMoveRule.create();
        CarMoveRuleValue carRandomMoveRuleValue = new MockCarRandomMoveRuleValue(4, Integer.MAX_VALUE);

        assertThat(carRandomMoveRule.check(carRandomMoveRuleValue)).isTrue();
    }

    @Test
    void checkMove_랜덤값이_4미만이면_false를_반환한다() {
        CarMoveRule carRandomMoveRule = CarRandomMoveRule.create();
        CarMoveRuleValue carRandomMoveRuleValue = new MockCarRandomMoveRuleValue(Integer.MIN_VALUE, 4);

        assertThat(carRandomMoveRule.check(carRandomMoveRuleValue)).isFalse();
    }
}