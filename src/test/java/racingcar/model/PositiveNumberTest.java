package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PositiveNumberTest {
    @Test
    void Positive_음수는_허용하지_않는다() {
        assertThatThrownBy(() -> new PositiveNumber(-1)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void isGreaterThanOrEqual_크거나같다_true() {
        PositiveNumber positiveNumber = new PositiveNumber(6);
        assertThat(positiveNumber.isGreaterThanOrEqual(5)).isTrue();
    }

    @Test
    void isGreaterThanOrEqual_크거나같다_false() {
        PositiveNumber positiveNumber = new PositiveNumber(6);
        assertThat(positiveNumber.isGreaterThanOrEqual(7)).isFalse();
    }

    @Test
    void plus_값을_더한다() {
        PositiveNumber positiveNumber = new PositiveNumber(4);
        PositiveNumber positiveNumberFrom = new PositiveNumber(6);
        positiveNumber.plus(positiveNumberFrom);
        assertThat(positiveNumber).isEqualTo(new PositiveNumber(10));
    }

    @Test
    void minus_값을_뺸다() {
        PositiveNumber positiveNumber = new PositiveNumber(6);
        PositiveNumber positiveNumberFrom = new PositiveNumber(4);
        positiveNumber.minus(positiveNumberFrom);
        assertThat(positiveNumber).isEqualTo(new PositiveNumber(2));
    }

    @Test
    void minus_값을_뺸_결과는_음수일수없다() {
        PositiveNumber positiveNumber = new PositiveNumber(4);
        PositiveNumber positiveNumberFrom = new PositiveNumber(6);
        assertThatThrownBy(() -> positiveNumber.minus(positiveNumberFrom)).isInstanceOf(RuntimeException.class);
    }
}