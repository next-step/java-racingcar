package study.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.Car;
import step2.RacingGame;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(3);
    }

    @Test
    void initiateCarObjectTest() {
        List<Car> cars = racingGame.carPositionsInitiate(3);
        assertThat(cars).hasSize(3);
    }

    @Test
    void moveCarTest() {
        assertThat(racingGame.carPositionsInitiate(5)).hasSize(5);
    }

    @Test
    void resultViewTest() {
        assertThat(racingGame.carPositionsInitiate(3)).hasSize(3);
        racingGame.execute();
    }
}
