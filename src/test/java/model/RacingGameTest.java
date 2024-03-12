package model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    void runByTrueStrategy() {
        List<Car> cars = Arrays.asList(new Car("test1", 1),
                new Car("test2", 2),
                new Car("test3", 3));

        int turn = 1;
        RacingGame racingGame = new RacingGame(cars, () -> true);
        RacingRecord result = racingGame.run(turn);

        Cars expected = new Cars(Arrays.asList(new Car("test1", 2),
                new Car("test2", 3),
                new Car("test3", 4)));

        assertThat(result.getRecords())
                .containsExactly(expected);
    }

    @Test
    void runByFalseStrategy() {
        List<Car> cars = Arrays.asList(new Car("test1", 1),
                new Car("test2", 2),
                new Car("test3", 3));

        int turn = 1;
        RacingGame racingGame = new RacingGame(cars, () -> false);
        RacingRecord result = racingGame.run(turn);

        Cars expected = new Cars(Arrays.asList(new Car("test1", 1),
                new Car("test2", 2),
                new Car("test3", 3)));

        assertThat(result.getRecords())
                .containsExactly(expected);
    }

    @Test
    void winners() {
        Car car1 = new Car("test1", 1);
        Car car2 = new Car("test2", 2);
        Car car3 = new Car("test3", 2);

        int turn = 1;
        List<Car> cars = Arrays.asList(car1, car2, car3);
        RacingGame racingGame = new RacingGame(cars, () -> false);
        RacingRecord result = racingGame.run(turn);

        assertThat(result.getWinners()).hasSize(2)
                .containsExactly(car2, car3);
    }
}
