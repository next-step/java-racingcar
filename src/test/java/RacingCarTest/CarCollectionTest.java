package RacingCarTest;

import racingcar.Car;
import racingcar.CarCollection;
import racingcar.MovementCondition;
import racingcar.SimpleCar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarCollectionTest {
    CarCollection carCollection;
    List<Car> cars;
    MovementCondition alwaysMoveCondition = new AlwaysMoveCondition();

    @BeforeEach
    void initCarCollection() {
        cars = new ArrayList<Car>();
        cars.add(new SimpleCar("A"));
        cars.add(new SimpleCar("B"));
        carCollection = new CarCollection(cars);
    }

    @Test
    void Given_AlwaysMoveCondition_When_Forward_Then_CarMoved() {
        //when
        carCollection.forward(alwaysMoveCondition);

        //then
        cars.forEach(c -> assertThat(c.getDistance()).isEqualTo(1));
    }

    @Test
    void GivenOneWinner_When_GetWinnerName_Then_ValidWinnerName() {
        //given
        Car winner = cars.get(0);
        winner.forward(alwaysMoveCondition);

        //when
        List<String> winnersName = carCollection.getWinnersName();

        //then
        assertThat(winnersName.size()).isEqualTo(1);
        assertThat(winnersName.get(0)).isEqualTo(winner.getName());
    }

}
