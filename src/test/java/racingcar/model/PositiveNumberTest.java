package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class PositiveNumberTest {
    @Test
    void Positive_음수는_허용하지_않는다() {
        assertThatThrownBy(() -> {
            new PositiveNumber(-1);
        }).isInstanceOf(RuntimeException.class);
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
    void add_값을_더한다() {
        PositiveNumber positiveNumberTo = new PositiveNumber(4);
        PositiveNumber positiveNumberFrom = new PositiveNumber(6);
        positiveNumberTo.add(positiveNumberFrom);
        assertThat(positiveNumberTo.getNumber()).isEqualTo(10);
    }
}