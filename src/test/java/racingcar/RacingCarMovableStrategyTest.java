package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarMovableStrategyTest {

    @DisplayName("4 이상만 움직일 수 있음")
    @ParameterizedTest
    @CsvSource({"1,false", "2,false", "3,false", "4,true", "5,true", "10,true"})
    void isMovable(int number, boolean expected) {
        MovableStrategy movableStrategy = new RacingCarMovableStrategy();
        assertThat(movableStrategy.isMovable(number)).isEqualTo(expected);
    }
}