package CarRacing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void setting() {
        car = new Car();
    }

    @DisplayName("랜덤값이 4이상이면 차가 움직이게 되는지")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void changeOfCarStatus(int random) {
        car.move(random);
        assertThat(car.getStatusLine()).isGreaterThan(0);
    }

    @DisplayName("랜덤값이 3이하일 경우 차가 움직이지 않는지")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void notChangeOfCarStatus(int random) {
        car.move(random);
        assertThat(car.getStatusLine()).isZero();
    }
}
