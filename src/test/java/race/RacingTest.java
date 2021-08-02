package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.controller.RacingGame;
import racing.model.Car;
import racing.model.Racing;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    private static int GAME_COUNT = 5;

    @Test
    @DisplayName("endGame test")
    void endGameTest() {
        RacingGame racingGame = new RacingGame();
        Racing racing = new Racing(new String[]{"test1", "test2", "test3"}, GAME_COUNT);
        racingGame.gameStart(racing);
        assertThat(racing.endGame()).isEqualTo(true);
    }

    @Test
    @DisplayName("racing test")
    void racingTest() {
        Racing racing = new Racing(new String[]{"test1", "test2", "test3"}, GAME_COUNT);
        List<Car> carList = racing.game();
        for (Car car : carList) {
            assertThat(car.totalDistance()).isGreaterThanOrEqualTo(0);
            assertThat(car.totalDistance()).isLessThanOrEqualTo(5);
        }
    }

}
