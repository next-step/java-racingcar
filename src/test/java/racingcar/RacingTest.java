package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.MoveCondition;
import racingcar.domain.RandomMoveCondition;

import static org.junit.jupiter.api.Assertions.*;

class RacingTest {

    @Test
    void start() {
        Racing racing = new Racing();

        MoveCondition moveCondition = new RandomMoveCondition();
        Car car = new Car(moveCondition);

    }

}