package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;

import java.util.List;

class RacingGameTest {

    private static final RacingGame racingGame = new RacingGame();

    @Test
    @DisplayName("car 생성 테스트")
    void createCarTest() {
        List<Car> carList = racingGame.createCar(3);
        Assertions.assertThat(carList).hasSize(3);
    }

}
