package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.movingstrategy.AlwayStopStrategy;
import racingcar.domain.movingstrategy.AlwaysGoStrategy;
import racingcar.domain.movingstrategy.MovingStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RacingCarTest {

    @Test
    @DisplayName("move 테스트: movingStrategy.movable이 false면 움직이지 않는다.")
    void move1() {
        MovingStrategy movingStrategy = new AlwayStopStrategy();

        RacingCar racingCar = new RacingCar(movingStrategy);

        racingCar.move();
        Position expectedResult = new Position(0);

        assertEquals(racingCar.getPosition(), expectedResult);
    }

    @Test
    @DisplayName("move 테스트: movingStrategy.movable이 true면 움직인다.")
    void move2() {
        MovingStrategy movingStrategy = new AlwaysGoStrategy();

        RacingCar racingCar = new RacingCar(movingStrategy);

        racingCar.move();
        racingCar.move();
        racingCar.move();
        racingCar.move();

        Position expectedResult = new Position(4);

        assertEquals(racingCar.getPosition(), expectedResult);
    }

    @Test
    @DisplayName("clone 테스트: 내부의 position도 카피되어야 한다")
    void clone1() throws CloneNotSupportedException {
        MovingStrategy movingStrategy = new AlwaysGoStrategy();
        RacingCar racingCar = new RacingCar(movingStrategy);

        RacingCar copy = racingCar.clone();
        copy.move();

        assertNotEquals(racingCar.getPosition(), copy.getPosition());
    }

}
