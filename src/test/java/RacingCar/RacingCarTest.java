package RacingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;
import java.util.InputMismatchException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RacingCarTest {

    @Test
    @DisplayName("정상 스캔 확인")
    void scanTest() {
        inputSystemIn("1");

        assertThat(InputView.scanInt()).isEqualTo(1);
    }

    @Test
    @DisplayName("스캔이 0보다 작은 경우")
    void lessThanZeroTest() {
        inputSystemIn("-1");

        assertThatThrownBy(() -> {
            InputView.scanInt();
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("input value is less than 0");
    }

    @Test
    @DisplayName("비정상 스캔 확인")
    void scanExceptionTest() {
        inputSystemIn("abc");

        assertThatThrownBy(() -> {
            InputView.scanInt();
        }).isInstanceOf(InputMismatchException.class)
                .hasMessageContaining("MisMatch input value");
    }

    private void inputSystemIn(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

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
