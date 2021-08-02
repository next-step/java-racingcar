package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import race.controller.TestRacingGame;
import racing.model.Car;
import racing.model.Racing;


import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

public class RacingTest {

    private static int GAME_COUNT = 5;

    @Test
    @DisplayName("endGame test")
    void endGameTest() {
        TestRacingGame racingGame = new TestRacingGame(GAME_COUNT);
        Racing racing = new Racing(new String[]{"test1", "test2", "test3"});
        List<Car> carList = racingGame.gameStartTest(racing);
        for (Car car : carList) {
            assertThat(car.totalDistance()).isGreaterThanOrEqualTo(0);
            assertThat(car.totalDistance()).isLessThanOrEqualTo(5);
        }
    }

}
