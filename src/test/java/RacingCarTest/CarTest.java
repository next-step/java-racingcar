package RacingCarTest;

import org.junit.jupiter.api.BeforeEach;
import racingcar.Car;
import racingcar.Distance;
import racingcar.MovementCondition;
import racingcar.SimpleCar;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    final String givenCarName = "Car";
    Car car;

    @BeforeEach
    void SetUp() {
        car = new SimpleCar(givenCarName);
    }

    @Test
    void When_getName_Then_CorrectName() {
        //when
        String actual = car.getName();

        //then
        assertThat(actual).isEqualTo(givenCarName);
    }

    @Test
    void Given_AlwaysMove_When_forward_Then_DistanceIncreased() {
        //given
        Distance initialDistance = new Distance();
        MovementCondition movementCondition = new AlwaysMoveCondition();

        //when
        Distance newDistance = car.forward(movementCondition);

        //then
        assertThat(newDistance).isEqualTo(initialDistance.increase());
    }

    @Test
    void Given_NoMove_When_forward_Then_DistanceNotChanged() {
        //given
        Distance initialDistance = new Distance();
        MovementCondition movementCondition = new NoMoveCondition();

        //when
        Distance newDistance = car.forward(movementCondition);

        //then
        assertThat(newDistance).isEqualTo(initialDistance);
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
