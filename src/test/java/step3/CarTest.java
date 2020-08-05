package step3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    @ParameterizedTest
    @CsvSource(value = {"a", "abcde"})
    void constructor(String name) {
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @ParameterizedTest
    @CsvSource(value = {"yongdae", "tester"})
    void constructorWithThrowRuntimeException(String name) {
        assertThatThrownBy(() -> {
            Car car = new Car(name);
        }).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"0 = 0", "1 = 0", "3 = 0", "4 = 1", "8 = 1", "9 = 1"}, delimiter = '=')
    void go(int power, int expect) {
        Car car = new Car();
        car.go(power);
        assertThat(car.getCurrentPosition()).isEqualTo(expect);
    }
}