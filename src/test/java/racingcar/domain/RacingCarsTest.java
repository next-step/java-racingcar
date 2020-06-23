package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.application.RacingGame;
import racingcar.utils.Const;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("최종적으로 자동차 위너 값 가져오기")
class RacingCarsTest {
    RacingCar racingCarNumber1, racingCarNumber2, racingCarNumber3;
    RacingCars racingCars;

    @BeforeEach
    void setUp() {
        racingCarNumber1 = new RacingCar("moon", 3);
        racingCarNumber2 = new RacingCar("kim", 2);
        racingCarNumber3 = new RacingCar("lee", 3);

        racingCars = new RacingCars(Arrays.asList(racingCarNumber1, racingCarNumber2, racingCarNumber3));
    }

    @Test
    @DisplayName("누가 위너인지 표시")
    void whoIsWinners() {
        RacingCars winner = racingCars.whoIsWinners();
        assertThat(winner).isEqualTo(new RacingCars(Arrays.asList(racingCarNumber1, racingCarNumber3)));
    }
}