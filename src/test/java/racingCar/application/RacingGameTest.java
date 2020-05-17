package racingCar.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @ParameterizedTest
    @CsvSource(value={"2,2", "2,5"})
    @DisplayName("자동차 Position 초기값 설정")
    void initRacingCars(int carCount, int time) {
        RacingGame racingGame = new RacingGame(carCount, time);

        for (int idx = 0; idx < carCount; idx++) {
            int position = racingGame.getRacingCarList().get(idx).getPosition();
            assertThat(position).isEqualTo(0);
        }
    }
}
