package RacingCarTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarCollectionTest {
    CarCollection carCollection;
    List<Car> cars;
    MovementCondition alwaysMoveCondition = new AlwaysMoveCondition();

    @BeforeEach
    void initCarCollection() {
        cars = new ArrayList<>();
        cars.add(new SimpleCar("A"));
        cars.add(new SimpleCar("B"));
        carCollection = new CarCollection(cars);
    }

    @Test
    void Given_AlwaysMoveCondition_When_Forward_Then_CarMoved() {
        //when
        List<Distance> distanceList = carCollection.forward(alwaysMoveCondition);

        //then
        distanceList.forEach(distance -> assertThat(distance).isEqualTo(new Distance(1)));
    }

    @Test
    void GivenOneWinner_When_GetWinnerName_Then_ValidWinnerName() {
        //given
        Car winner = cars.get(0);
        winner.forward(alwaysMoveCondition);

        //when
        List<Name> winnersName = carCollection.getWinnersName();

        //then
        assertThat(winnersName.size()).isEqualTo(1);
        assertThat(winnersName.get(0)).isEqualTo(new Name("A"));
    }

}
