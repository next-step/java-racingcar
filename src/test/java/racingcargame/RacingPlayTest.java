package racingcargame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingPlayTest {

    @Test
    void readyForRacingTest() {
        RacingPlay racingPlay = new RacingPlay();
        List<Car> carList = racingPlay.readyForRacing(2);
        assertThat(carList).hasSize(2);
    }

    @DisplayName("isPossibleToMove 수행 시 4 이상일 경우 true, 그렇지 않을 경우 false 를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"4, true", "5, true", "1, false"})
    void isPossibleToMove_ShouldReturnTrueOrFalse(int input, boolean expected) {
        RacingPlay racingPlay = new RacingPlay();
        assertThat(racingPlay.isPossibleToMove(input)).isEqualTo(expected);
    }

    @Test
    void moveForwardTest() {
        RacingPlay racingPlay = new RacingPlay();
        Car car = new Car("");

        racingPlay.moveForward(4, car);
        assertThat(car.getLocation()).isEqualTo("-");
    }
}