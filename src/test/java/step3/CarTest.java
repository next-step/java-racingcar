package step3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void goByFalse(int power) {
        Car car = new Car();
        car.go(power);
        assertThat(car.getCurrentPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void goByTrue(int power) {
        Car car = new Car();
        car.go(power);
        assertThat(car.getCurrentPosition()).isEqualTo(0);
    }
}