package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarTest {
    private Car car;

    @BeforeEach
    public void setUp() {
        car = Car.newCar("car");
    }

    @ParameterizedTest
    @CsvSource(value = {"123456", "1234567"})
    @DisplayName("자동차 이름 기준에 부합하지 않는 경우")
    public void new_car_test(String value) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Car.newCar(value));
    }
}
