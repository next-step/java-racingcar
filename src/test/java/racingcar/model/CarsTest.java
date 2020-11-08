package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private Motor motor;

    @BeforeEach
    void setup() {
        motor = new TesterMotor();
    }

    @DisplayName("of() 테스트")
    @Test
    void of() {
        int carCount = 3;
        Cars cars = Cars.of(carCount, motor);

        assertThat(cars.sizeOfCar()).isEqualTo(carCount);
    }

    @DisplayName("getPositions() 테스트")
    @Test
    void getPositions() {
        Car car1 = new Car(motor);
        Car car2 = new Car(motor);
        car1.move();
        car1.move();

        List<Integer> expectedRsult = Arrays.asList(2, 0);

        Cars cars = new Cars(Arrays.asList(car1, car2));

        assertThat(cars.getPositions()).isEqualTo(expectedRsult);
    }
}
