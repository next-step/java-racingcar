package RacingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;
import java.util.InputMismatchException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RacingTest {

    @Test
    @DisplayName("자동차 대수 테스트")
    void initRacingTest() {
        Racing racing = new Racing(3, 5);
        assertThat(racing.getCarList().size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("자동차 이동 테스트")
    @CsvSource(value = {"3:1", "4:2"}, delimiter = ':')
    void move(int value, int result) {
        Car car = new Car();
        car.move(value);
        assertThat(car.getPosition()).isEqualTo(result);
    }
}
