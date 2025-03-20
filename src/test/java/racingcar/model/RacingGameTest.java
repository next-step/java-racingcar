package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("입력한 자동차 대수만큼 자동차 객체를 생성하고 초기 위치는 0이다.")
    void createCarsTest() {
        List<String> carNames = List.of("car1", "car2", "car3");

        RacingGame racingGame = RacingGame.createRacingGame(carNames);

        assertThat(racingGame.hasCarCount(carNames.size())).isTrue();
        assertThat(racingGame.areAllCarsAtPosition(new Position(0))).isTrue();
    }
}
