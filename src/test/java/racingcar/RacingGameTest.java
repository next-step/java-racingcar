package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    @Test
    void testTryGame() {
        RacingGame racingGame = new RacingGame() {
            @Override
            protected boolean isMovable() {
                return true;
            }
        };

        racingGame.createCars(1);
        racingGame.tryGame();
        racingGame.tryGame();
        racingGame.tryGame();

        assertThat(racingGame.getCars().get(0).getPosition()).isEqualTo(3);
    }

    @Test
    void testGetWinnerNames() {
        RacingGame racingGame = new RacingGame();
        racingGame.createCars(List.of("winner1", "winner2", "loser"));

        List<Car> cars = racingGame.getCars();
        cars.get(0).forward();
        cars.get(1).forward();

        assertThat(racingGame.getWinnerNames()).containsOnly("winner1", "winner2");
    }
}
