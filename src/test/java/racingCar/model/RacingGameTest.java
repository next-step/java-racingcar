package racingCar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(new String[]{"pobi", "crong", "honux"}, 5);
    }

    @Test
    void create() {
        Cars cars = new Cars(Arrays.asList(new Car("pobi"), new Car("crong"), new Car("honux")));
        assertThat(racingGame).isEqualTo(new RacingGame(cars, 5));
    }

    @DisplayName("이동")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void move(int index) {
        List<Car> cars = racingGame.moveCars(() -> true);
        assertThat(cars.get(index).getPosition()).isEqualTo(1);
    }

    @Test
    void findWinner() {
        racingGame.moveCars(() -> true);
        assertThat(racingGame.findWinners())
                .containsExactly(new Car("pobi", 1), new Car("crong", 1), new Car("honux", 1));
    }

}