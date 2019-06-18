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

        Car car1 = Car.createWithDrivingRule(alwaysTrueRule, "yong");
        Car car2 = Car.createWithDrivingRule(alwaysTrueRule, "pobi");
        Car car3 = Car.createWithDrivingRule(alwaysFalseRule, "crong");

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        cars = Cars.create(carList);
    }

    @Test
    void Referee는_우승자들을_판별한다() {
        cars.move();
        cars.move();

        CarInformation expectedWinner1 = new CarInformation("yong");
        CarInformation expectedWinner2 = new CarInformation("pobi");

        assertThat(Referee.judgeWinners(cars)).containsExactly(expectedWinner1, expectedWinner2);
    }
}