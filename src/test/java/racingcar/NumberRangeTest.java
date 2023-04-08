package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberRangeTest {

    @Test
    void getOne_메서드는_정수만_리턴한다() {
        for (int i = 0; i < 100; i++) {
            assertThat(NumberRange.getOne())
                .isInstanceOf(Integer.class);
        }
    }

    @Test
    void getOne_메서드는_0부터9까지의_숫자만_리턴한다() {
        for (int i = 0; i < 100; i++) {
            assertThat(NumberRange.getOne())
                .isNotNegative()
                .isLessThanOrEqualTo(9);
        }
    }
}