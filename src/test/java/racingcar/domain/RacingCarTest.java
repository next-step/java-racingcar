package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.movingstrategy.MovingStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RacingCarTest {

    @Test
    @DisplayName("move 테스트: movingStrategy.movable이 false면 움직이지 않는다.")
    void move1() {
        MovingStrategy movingStrategy = mock(MovingStrategy.class);
        when(movingStrategy.movable()).thenReturn(false);

        RacingCar racingCar = new RacingCar(movingStrategy);

        racingCar.move();
        Position expectedResult = new Position(0);

        assertEquals(racingCar.getPosition(), expectedResult);
    }

    @Test
    @DisplayName("move 테스트: movingStrategy.movable이 true면 움직인다.")
    void move2() {
        MovingStrategy movingStrategy = mock(MovingStrategy.class);
        when(movingStrategy.movable()).thenReturn(true);

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
        MovingStrategy movingStrategy = mock(MovingStrategy.class);
        RacingCar racingCar = new RacingCar(movingStrategy);

        RacingCar copy = racingCar.clone();
        copy.move();

        assertNotEquals(racingCar.getPosition(), copy.getPosition());
    }

}
