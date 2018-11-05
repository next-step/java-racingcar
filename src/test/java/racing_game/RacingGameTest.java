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
        final String[] carNames = {"pobi", "crong", "honux"};

        List<Car> cars = racingGame.createCars(carNames);

        assertThat(cars.size()).isEqualTo(carNames.length);
        assertThat(cars).allMatch(Objects::nonNull);
        assertThat(cars.stream().map(Car::getName).toArray()).isEqualTo(carNames);
    }

}