package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
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
        MovingStrategy movingStrategy = new TestSuccessMoveStrategy();

        roundCars.moveCars(movingStrategy);
        roundCars.moveCars(movingStrategy);

        List<Car> cars = roundCars.retrieveCars();
        assertThat(cars)
                .map(Car::getPosition)
                .containsExactly(2, 2, 2);
    }

    @Test
    void moveCars_포지션_증가실패_전략() {
        MovingStrategy movingStrategy = new TestFailMoveStrategy();

        roundCars.moveCars(movingStrategy);
        roundCars.moveCars(movingStrategy);

        List<Car> cars = roundCars.retrieveCars();
        assertThat(cars)
                .map(Car::getPosition)
                .containsExactly(0, 0, 0);
    }

    @Test
    void 우승자_도출_테스트() {
        MovingStrategy movingStrategy = new TestSuccessMoveStrategy();

        roundCars.moveCars(movingStrategy);
        roundCars.moveCars(movingStrategy);
        List<Car> cars = roundCars.retrieveCars();
        Car winnerCar = cars.get(1);
        winnerCar.move(movingStrategy);

        List<String> winners = roundCars.retrieveWinners();
        assertThat(winners)
                .containsExactly(winnerCar.getName());
    }

    @Test
    void deepCopy_서로_다른_인스턴스인지() {
        RoundCars copyRoundCars = roundCars.getRoundCars();
        List<Car> cars = roundCars.retrieveCars();
        List<Car> copyCar = copyRoundCars.retrieveCars();

        Assertions.assertAll(
                () -> assertThat(roundCars)
                        .as("서로 다른 RoundCar인스턴스 인지")
                        .isNotEqualTo(copyRoundCars),
                () -> assertThat(cars)
                        .as("서로 다른 List인스턴스 인지")
                        .isNotEqualTo(copyCar),
                () -> assertThat(cars)
                        .as("서로 다른 각각의 Car인스턴스 인지")
                        .doesNotContain(copyCar.toArray(new Car[0]))
        );
    }

}