package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovingForwardConditionTest {

    @DisplayName("값이 4이상일 경우 전진하는 조건을 만족한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void isSatisfyForwardCondition(int value) {
        boolean expected = value >= MovingForwardCondition.THRESHOLD;
        boolean isSatisfied = MovingForwardCondition.isSatisfied(value);
        assertEquals(expected, isSatisfied);
        assertEquals(4, MovingForwardCondition.THRESHOLD);
    }
}
