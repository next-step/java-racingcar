package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private Motor motor;
    private String[] carsName;

    @BeforeEach
    void setup() {
        motor = new TesterMotor();
        carsName = new String[]{"jin", "hyun", "hwi", "woong"};
    }

    @DisplayName("of() 테스트")
    @Test
    void of() {
        Cars cars = Cars.of(carsName, motor);

        assertThat(cars.sizeOfCar()).isEqualTo(carsName.length);
    }

    @DisplayName("getPositions() 테스트")
    @Test
    void getPositions() {
        Car car1 = new Car(carsName[0], motor);
        Car car2 = new Car(carsName[1], motor);
        car1.move();
        car1.move();

        List<Integer> expectedRsult = Arrays.asList(2, 0);

        Cars cars = new Cars(Arrays.asList(car1, car2));

        assertThat(cars.getPositions()).isEqualTo(expectedRsult);
    }
}
