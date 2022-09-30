package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.TestMovingStrategy.TestFailMoveStrategy;
import racingcar.TestMovingStrategy.TestSuccessMoveStrategy;
import racingcar.strategy.MovingStrategy;

class RoundCarsTest {

    RoundCars roundCars;
    List<String> names;

    @BeforeEach
    void setUp() {
        names = Arrays.asList("yunhw", "lowon", "pobi");
        roundCars = new RoundCars(names);
    }

    @Test
    @DisplayName("생성자가 List<Car>로 넘어올 때 정상 생성")
    void constructorList() {
        List<Car> cars = roundCars.retrieveCars();

        assertThat(cars)
                .map(Car::getName)
                .containsExactly(names.get(0), names.get(1), names.get(2));
    }

    @Test
    void moveCars_포지션_증가성공_전략() {
        RacingRecord racingRecord = new RacingRecord();
        MovingStrategy movingStrategy = new TestSuccessMoveStrategy();

        roundCars.moveCars(racingRecord, movingStrategy);
        roundCars.moveCars(racingRecord, movingStrategy);

        List<Car> cars = roundCars.retrieveCars();
        assertThat(cars)
                .map(Car::getPosition)
                .containsExactly(2, 2, 2);
    }

    @Test
    void moveCars_포지션_증가실패_전략() {
        RacingRecord racingRecord = new RacingRecord();
        MovingStrategy movingStrategy = new TestFailMoveStrategy();

        roundCars.moveCars(racingRecord, movingStrategy);
        roundCars.moveCars(racingRecord, movingStrategy);

        List<Car> cars = roundCars.retrieveCars();
        assertThat(cars)
                .map(Car::getPosition)
                .containsExactly(0, 0, 0);
    }

}