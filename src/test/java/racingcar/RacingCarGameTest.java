package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.strategy.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {

    @Test
    void 게임을_진행했을때_움직인레이싱카들은_position이_증가한다() {
        List<RacingCar> racingCars = new ArrayList<>();
        TestAlwaysMoveStrategy testAlwaysMoveStrategy = new TestAlwaysMoveStrategy();
        for (int i = 0; i < 10; i++) {
            racingCars.add(new RacingCar("pobi" + i, testAlwaysMoveStrategy));
        }
        RacingCarGame racingCarGame = new RacingCarGame(racingCars);
        racingCarGame.play();
        assertThat(testAlwaysMoveStrategy.getPosition())
            .isEqualTo(10);
    }

    @Test
    void 게임을_진행했을때_멈춘레이싱카들은_position이_증가하지_않는다() {
        List<RacingCar> racingCars = new ArrayList<>();
        TestAlwaysStopStrategy testAlwaysStopStrategy = new TestAlwaysStopStrategy();
        for (int i = 0; i < 10; i++) {
            racingCars.add(new RacingCar("pobi" + i, testAlwaysStopStrategy));
        }
        RacingCarGame racingCarGame = new RacingCarGame(racingCars);
        racingCarGame.play();
        for (RacingCar racingCar : racingCars) {
            assertThat(testAlwaysStopStrategy.getPosition())
                .withFailMessage("%d번째 인덱스에서 오류가 발생했습니다.", racingCars.indexOf(racingCar))
                .isEqualTo(0);
        }
    }
}