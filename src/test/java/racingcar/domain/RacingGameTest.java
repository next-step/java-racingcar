package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class RacingGameTest {
    @Test
    @DisplayName("n개의 자동차를 만들 수 있다.")
    void generateCars() {
        // given
        String[] carNames = {"tody", "podi", "kim"};
        RacingGame racingGame = new RacingGame(carNames);
        // when
        List<Car> cars = racingGame.getCars();
        // then
        Assertions.assertThat(cars).hasSize(3);
    }
}