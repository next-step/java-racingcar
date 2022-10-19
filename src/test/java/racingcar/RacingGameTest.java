package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;

public class RacingGameTest {

    @Test
    void testTryGame() {
        Cars cars = Cars.createCarsByNumber(1);
        RacingGame racingGame = new RacingGame(cars) {
            @Override
            protected boolean isMovable() {
                return true;
            }
        };

        racingGame.tryGame();
        racingGame.tryGame();
        racingGame.tryGame();

        assertThat(racingGame.getCars().get(0).getPosition()).isEqualTo(3);
    }

    @Test
    void testGetWinnerNames() {
        Car car1 = new Car("win1", 2);
        Car car2 = new Car("win2", 2);
        Car car3 = new Car("loser", 1);
        Cars cars = new Cars(List.of(car1, car2, car3));
        RacingGame racingGame = new RacingGame(cars);

        assertThat(racingGame.getWinnerNames()).containsOnly("win1", "win2");
    }
}
