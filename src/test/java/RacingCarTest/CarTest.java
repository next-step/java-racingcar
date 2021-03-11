package RacingCarTest;

import RacingCar.Car;
import RacingCar.SimpleCar;
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
    void When_forward_Then_DistanceIncreased() {
        int initialDistance = car.getDistance();

        //when
        car.forward();

        //then
        assertThat(car.getDistance()).isEqualTo(initialDistance + 1);
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
