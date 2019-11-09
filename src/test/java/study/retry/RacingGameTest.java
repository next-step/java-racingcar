package study.retry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retry.domain.Car;
import retry.domain.Cars;
import retry.domain.RacingGame;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private RacingGame racingGame;
    private Cars racingCars;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = Arrays.asList(new Car("test", 0), new Car("test1", 0), new Car("test2", 0));
        racingCars = new Cars(cars);
        racingGame = new RacingGame(racingCars);
    }

    @Test
    void racingCarsMoveTest() {
        for (Cars cars1 : racingGame.repeatRacingGame()) {
            assertThat(cars1.getCars()).hasSize(3);
        }
    }

    @Test
    void racingGameLoopTest() {
        List<Cars> racingGames = racingGame.execute(1);
        assertThat(racingGames).hasSize(1);
        racingGame.getWinners();
    }
}
