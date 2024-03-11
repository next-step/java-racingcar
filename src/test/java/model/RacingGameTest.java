package model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    void runByTrueStrategy() {
        MoveStrategy trueMoveStrategy = () -> true;
        List<Car> cars = Arrays.asList(new Car("test1", 1, trueMoveStrategy),
                new Car("test2", 2, trueMoveStrategy),
                new Car("test3", 3, trueMoveStrategy));

        int turn = 1;
        RacingGame racingGame = new RacingGame(cars);
        RacingRecord result = racingGame.run(turn);

        Cars expected = new Cars(Arrays.asList(new Car("test1", 2, trueMoveStrategy),
                new Car("test2", 3, trueMoveStrategy),
                new Car("test3", 4, trueMoveStrategy)));

        assertThat(result.getRecords())
                .containsExactly(expected);
    }

    @Test
    void runByFalseStrategy() {
        MoveStrategy falseMoveStrategy = () -> false;
        List<Car> cars = Arrays.asList(new Car("test1", 1, falseMoveStrategy),
                new Car("test2", 2, falseMoveStrategy),
                new Car("test3", 3, falseMoveStrategy));

        int turn = 1;
        RacingGame racingGame = new RacingGame(cars);
        RacingRecord result = racingGame.run(turn);

        Cars expected = new Cars(Arrays.asList(new Car("test1", 1, falseMoveStrategy),
                new Car("test2", 2, falseMoveStrategy),
                new Car("test3", 3, falseMoveStrategy)));

        assertThat(result.getRecords())
                .containsExactly(expected);
    }

    @Test
    void winnerNames() {
        List<Car> cars = Arrays.asList(new Car("test1", 1), new Car("test2", 2), new Car("test3", 2));
        RacingGame racingGame = new RacingGame(cars);

        List<String> winnerNames = racingGame.winnerNames();
        assertThat(winnerNames).hasSize(2)
                .containsExactly("test2", "test3");
    }
}
