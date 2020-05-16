package step3;


import calculator.StringCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.car.Car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("testCar");
    }

    @Test
    @DisplayName("정상적인 자동차 이동 테스트")
    void carMoveTestFunction() {
        car.move(0);

        assertThat(car.getPosition()).isEqualTo(5);
    }

    @Test
    @DisplayName("정상적인 자동차 비 이동 테스트")
    void carStopTestFunction() {
        car.move(10);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
