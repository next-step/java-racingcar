package model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    void runByTrueStrategy() {
        MoveStrategy trueMoveStrategy = () -> true;
        List<Car> cars = Arrays.asList(new Car("test1", 1, trueMoveStrategy), new Car("test2", 2, trueMoveStrategy), new Car("test3", 3, trueMoveStrategy));

        int turn = 1;
        RacingGame racingGame = new RacingGame(cars);
        RacingRecord result = racingGame.run(turn);

        assertThat(result.racingRecord(turn))
                .containsExactly(new Record("test1", 2), new Record("test2", 3), new Record("test3", 4));
    }

    @Test
    void runByFalseStrategy() {
        MoveStrategy falseMoveStrategy = () -> false;
        List<Car> cars = Arrays.asList(new Car("test1", 1, falseMoveStrategy), new Car("test2", 2, falseMoveStrategy), new Car("test3", 3, falseMoveStrategy));

        int turn = 1;
        RacingGame racingGame = new RacingGame(cars);
        RacingRecord result = racingGame.run(turn);

        assertThat(result.racingRecord(turn))
                .containsExactly(new Record("test1", 1), new Record("test2", 2), new Record("test3", 3));
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
