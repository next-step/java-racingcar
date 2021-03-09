package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovingForwardConditionTest {

    @DisplayName("값이 4이상일 경우 전진하는 조건을 만족한다.")
    @ParameterizedTest
    @CsvSource({"0,false", "3,false", "4,true", "8,true"})
    void isSatisfyForwardCondition(int value, boolean expected) {
        boolean isSatisfied = MovingForwardCondition.isSatisfied(value);
        assertEquals(expected, isSatisfied);
    }
}
