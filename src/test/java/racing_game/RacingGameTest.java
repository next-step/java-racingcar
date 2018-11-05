package racing_game;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private RacingGame racingGame;

    @Before
    public void setup() {
        this.racingGame = new RacingGame();
    }


    @Test
    public void 자동차_만들기() {
        final int carCount = 2;

        List<Car> cars = racingGame.createCars(carCount);

        assertThat(cars.size()).isEqualTo(carCount);
        assertThat(cars).allMatch(Objects::nonNull);
    }

}