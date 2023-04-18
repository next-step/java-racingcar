package refactoring.racingcar.domain;

import org.junit.jupiter.api.Test;
import refactoring.racingcar.domain.strategy.AlwaysMoveStrategy;
import refactoring.racingcar.domain.strategy.AlwaysStopStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    void 움직인_자동차들은_위치가_증가한다() {
        List<RacingCar> racingCars = Arrays.asList(
            new RacingCar(new AlwaysMoveStrategy(), "pobi"),
            new RacingCar(new AlwaysMoveStrategy(), "crong"),
            new RacingCar(new AlwaysMoveStrategy(), "honux")
        );
        RacingGame racingGame = new RacingGame(racingCars);
        racingGame.play();
        for (RacingCar racingCar : racingCars) {
            assertThat(racingCar.getPosition())
                .withFailMessage(racingCars.indexOf(racingCar) + "번 인덱스에서 에러 발생")
                .isEqualTo(new CarPosition(1));
        }
    }

    @Test
    void 움직이지_않은_자동차들은_위치가_증가하지_않는다() {
        List<RacingCar> racingCars = Arrays.asList(
            new RacingCar(new AlwaysStopStrategy(), "pobi"),
            new RacingCar(new AlwaysStopStrategy(), "crong"),
            new RacingCar(new AlwaysStopStrategy(), "honux")
        );
        RacingGame racingGame = new RacingGame(racingCars);
        racingGame.play();
        for (RacingCar racingCar : racingCars) {
            assertThat(racingCar.getPosition())
                .withFailMessage(racingCars.indexOf(racingCar) + "번 인덱스에서 에러 발생")
                .isEqualTo(new CarPosition(0));
        }
    }
}
