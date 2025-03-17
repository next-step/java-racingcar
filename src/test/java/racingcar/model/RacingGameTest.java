package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("입력한 자동차 대수만큼 자동차 객체를 생성한다.")
    void createCarsTest() {
        int carCount = 3;
        RacingGame racingGame = new RacingGame(carCount);

        assertThat(racingGame.cars).hasSize(carCount);
    }
}
