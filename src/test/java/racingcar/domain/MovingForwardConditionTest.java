package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovingForwardConditionTest {

    @DisplayName("값이 threshold 이상일 경우 전진하는 조건을 만족한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void isSatisfyForwardCondition(int value) {
        boolean expected = value >= MovingForwardCondition.THRESHOLD;
        boolean isSatisfied = MovingForwardCondition.isSatisfied(value);

        assertEquals(expected, isSatisfied);
    }

    @DisplayName("자동차 전진, 정지를 결정하는 임계값은 4이다.")
    @Test
    public void thresholdIsFour() {
        assertEquals(4, MovingForwardCondition.THRESHOLD);
    }
}
