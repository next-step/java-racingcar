package racing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    private RacingGame racingGame;
    private List<Car> cars = new ArrayList<>();
    private int tries = 3;

    @BeforeEach
    void setUp() {
        cars.add(new Car(() -> true, "test1"));
        cars.add(new Car(() -> false, "test2"));
        cars.add(new Car(() -> false, "test2"));

        racingGame = new RacingGame(Collections.emptyList(), tries) {
            @Override
            protected List<Car> createCars(List<String> namesOfCars) {
                return cars;
            }
        };

        racingGame.doRaces();
    }

    @Test
    void 레이싱_결과_테스트() {
        List<Car> finishedCars = racingGame.getCars();

        assertThat(finishedCars.size()).isEqualTo(cars.size());
        assertThat(finishedCars.get(0).getPosition()).isEqualTo(tries);
        assertThat(finishedCars.get(1).getPosition()).isEqualTo(0);
        assertThat(finishedCars.get(2).getPosition()).isEqualTo(0);
    }

    @Test
    void 우승자_테스트() {
        List<String> winnerNames = racingGame.getWinnerNames();
        assertThat(winnerNames).isEqualTo(Arrays.asList("test1"));
    }
}