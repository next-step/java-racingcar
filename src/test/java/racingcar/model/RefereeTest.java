package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RefereeTest {
    private Cars cars;
    private List<CarName> names;

    @BeforeEach
    void setUp() {
        DrivingRule alwaysTrueRule = () -> true;
        DrivingRule alwaysFalseRule = () -> false;

        names = Arrays.asList(CarName.valueOf("yong")
                , CarName.valueOf("pobi")
                , CarName.valueOf("crong"));

        cars = Cars.create(Arrays.asList(Car.createWithDrivingRule(names.get(0), alwaysTrueRule)
                , Car.createWithDrivingRule(names.get(1), alwaysTrueRule)
                , Car.createWithDrivingRule(names.get(2), alwaysFalseRule)));
    }

    @Test
    void Referee는_우승자들을_판별한다() {
        cars.move();
        cars.move();

        CarInformation expectedWinner1 = CarInformation.create(names.get(0));
        CarInformation expectedWinner2 = CarInformation.create(names.get(1));

        assertThat(Referee.judgeWinners(cars)).containsExactly(expectedWinner1, expectedWinner2);
    }
}