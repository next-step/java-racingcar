package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RefereeTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        List<Car> carList = new ArrayList<>();
        DrivingRule alwaysTrueRule = () -> true;
        DrivingRule alwaysFalseRule = () -> false;

        Car car1 = Car.createWithDrivingRule("yong", alwaysTrueRule);
        Car car2 = Car.createWithDrivingRule( "pobi", alwaysTrueRule);
        Car car3 = Car.createWithDrivingRule( "crong", alwaysFalseRule);

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        cars = Cars.create(carList);
    }

    @Test
    void Referee는_우승자들을_판별한다() {
        cars.move();
        cars.move();

        CarInformation expectedWinner1 = CarInformation.create("yong");
        CarInformation expectedWinner2 = CarInformation.create("pobi");

        assertThat(Referee.judgeWinners(cars)).containsExactly(expectedWinner1, expectedWinner2);
    }
}