package RacingCarTest;

import racingcar.Car;
import racingcar.MovementCondition;
import racingcar.SimpleCar;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    final String givenCarName = "Car";
    Car car = new SimpleCar(givenCarName);

    @Test
    void When_getName_Then_CorrectName() {
        //when
        String actual = car.getName();

        //then
        assertThat(actual).isEqualTo(givenCarName);
    }

    @Test
    void Given_AlwaysMove_When_forward_Then_DistanceIncreased() {
        int initialDistance = car.getDistance();

        //given
        MovementCondition movementCondition = new AlwaysMoveCondition();

        //when
        car.forward(movementCondition);

        //then
        assertThat(car.getDistance()).isEqualTo(initialDistance + 1);
    }

    @Test
    void Given_NoMove_When_forward_Then_DistanceNotChanged() {
        int initialDistance = car.getDistance();

        //given
        MovementCondition movementCondition = new NoMoveCondition();

        //when
        car.forward(movementCondition);

        //then
        assertThat(car.getDistance()).isEqualTo(initialDistance);
    }

    @Test
    void Given_LongCarName_When_NewSimpleCar_Then_IllegalArgumentException() {
        String longCarName = "LongCarName";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new SimpleCar(longCarName);
                });
    }
}
