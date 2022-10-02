package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.TestMovingStrategy.TestSuccessMoveStrategy;
import racingcar.strategy.MovingStrategy;

class RacingGameTest {

    List<String> names;

    @BeforeEach
    void setUp() {
        names = Arrays.asList("y1", "a2", "b3");
    }

    @Test
    void constructorTryNumMinusFail() {
        assertThatThrownBy(() -> new RacingGame(-1, names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void racingStart() {
        RacingGame racingGame = new RacingGame(3, names);
        MovingStrategy movingStrategy = new TestSuccessMoveStrategy();
        racingGame.changeMovingStrategy(movingStrategy);

        RacingRecord racingRecord = racingGame.racingStart();

        List<RoundCars> roundCars = racingRecord.retrieveRecord();
        assertThat(roundCars)
                .flatMap(RoundCars::retrieveCars)
                .map(Car::getPosition)
                .containsExactly(1, 1, 1, 2, 2, 2, 3, 3, 3);
    }
}