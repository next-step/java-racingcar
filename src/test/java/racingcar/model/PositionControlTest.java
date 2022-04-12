package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PositionControlTest {

    @ParameterizedTest
    @DisplayName("랜덤값이 4이상인 경우 true 그 외는 false 반환")
    @CsvSource({"0,false", "3,false", "4,true", "9,true"})
    void returnTrueOrFalseAccordingRandomValue(int input, boolean expected) {
        PositionControl positionControl = new PositionControl();
        assertThat(positionControl.matchMovementCondition(input)).isEqualTo(expected);
    }
}