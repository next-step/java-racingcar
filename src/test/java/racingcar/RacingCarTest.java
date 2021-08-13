package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    private final RacingCar racingCar = new RacingCar();

    @DisplayName("자동차의 출발 위치는 0")
    @Test
    void startingPositionOfTheCarIsZero() {
        assertThat(racingCar.getPosition())
                .isEqualTo(0);
    }

    @DisplayName("자동차 4 이상 4 미만 작동 확인")
    @ParameterizedTest
    @CsvSource(value = {"1:0", "4:1", "8:1"}, delimiter = ':')
    void racingCarMove (int randomNumber, int expect){
        racingCar.move(randomNumber);
        int result = racingCar.getPosition();
        assertThat(result).isEqualTo(expect);
    }

}
