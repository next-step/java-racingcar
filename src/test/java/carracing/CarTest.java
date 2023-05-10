package carracing;

import carracing.domain.Car;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void car_init_location() {
        assertThat(new Car("name").getLocation()).isZero();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9, 10})
    void go(int randomNum) {
        Car car = new Car("jayb") {
            @Override
            protected int getRandomNumber() {
                return randomNum;
            }
        };
        car.go();
        assertThat(car.getLocation()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void no_go(int randomNum) {
        Car car = new Car("jayb") {
            @Override
            protected int getRandomNumber() {
                return randomNum;
            }
        };
        car.go();
        assertThat(car.getLocation()).isEqualTo(0);
    }
}
