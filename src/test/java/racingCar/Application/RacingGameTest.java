package racingCar.Application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    @ParameterizedTest
    @CsvSource(value={"2,2", "2,5"})
    @DisplayName("자동차 Position 초기값 설정")
    void initRacingCars(int a, int b) {
        RacingGame racingGame = new RacingGame(a, b);
        racingGame.initRacingCars();
        for (int idx = 0; idx < racingGame.getCarCount(); idx++) {
            int position = racingGame.getRacingCarList().get(idx).getPosition();
            assertThat(position).isEqualTo(0);
        }
    }
}
