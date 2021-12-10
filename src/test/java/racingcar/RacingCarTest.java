package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.movingstrategy.MovingStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RacingCarTest {

    @Test
    @DisplayName("move 테스트: movingStrategy.movable이 false면 움직이지 않는다.")
    void move1() {
        MovingStrategy movingStrategy = mock(MovingStrategy.class);
        when(movingStrategy.movable()).thenReturn(false);

        RacingCar racingCar = new RacingCar(movingStrategy);

        Position position = racingCar.move();
        Position expectedResult = new Position(0);

        assertEquals(position, expectedResult);
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
        Position position = racingCar.move();

        Position expectedResult = new Position(4);

        assertEquals(position, expectedResult);
    }

}
