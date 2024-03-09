package model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    void runByTrueStrategy() {
        MoveStrategy trueMoveStrategy = () -> true;
        List<Car> cars = Arrays.asList(new Car(1, trueMoveStrategy), new Car(2, trueMoveStrategy), new Car(3, trueMoveStrategy));

        int turn = 1;
        RacingGame racingGame = new RacingGame(cars);
        RacingRecord result = racingGame.run(turn);

        assertThat(result.racingRecord(turn))
                .containsExactly(new Record(2), new Record(3), new Record(4));
    }

    @Test
    void runByFalseStrategy() {
        MoveStrategy falseMoveStrategy = () -> false;
        List<Car> cars = Arrays.asList(new Car(1, falseMoveStrategy), new Car(2, falseMoveStrategy), new Car(3, falseMoveStrategy));

        int turn = 1;
        RacingGame racingGame = new RacingGame(cars);
        RacingRecord result = racingGame.run(turn);

        assertThat(result.racingRecord(turn))
                .containsExactly(new Record(1), new Record(2), new Record(3));
    }

}
