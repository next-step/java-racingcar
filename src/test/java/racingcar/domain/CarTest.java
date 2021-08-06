package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarTest {
    Car car = new Car();

    @DisplayName("isAbleToMove : 전진 가능 기준인 4 이상의 값일 떄 true 반환")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @CsvSource({"4, true", "3, false", "0, false", "8, true"})
    void isAbleToMove(int input, boolean expected) {
        assertThat(car.isAbleToMove(input)).isEqualTo(expected);
    }

    @DisplayName("isAbleToMove : 입력 값이 0~9 사이가 아니면 Exception 발생")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @ValueSource(ints = {-1, 10})
    void isAbleToMove_ShouldThrowIllegalArgumentException(int input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    car.isAbleToMove(input);
                });
    }

    @DisplayName("goForward : Car 전진 테스트")
    @Test
    void goForward() {
        int currentLocation = car.getLocation();
        car.goForward();
        assertThat(car.getLocation()).isEqualTo(currentLocation + 1);

        currentLocation = car.getLocation();
        car.goForward();
        car.goForward();
        car.goForward();
        assertThat(car.getLocation()).isEqualTo(currentLocation + 3);
    }

    @DisplayName("resetLocation : Car Location reset 테스트")
    @Test
    void resetLocation() {
        car.goForward();
        car.goForward();
        assertThat(car.getLocation()).isNotEqualTo(0);
        car.resetLocation();
        assertThat(car.getLocation()).isEqualTo(0);
    }

    @DisplayName("move : 입력 값이 4 이상이면 car가 전진하는 기능 테스트")
    @ParameterizedTest
    @CsvSource({"0, 0", "3, 0", "4, 1", "9, 1"})
    void move(int value, int expected) {
        Random ran = new Random();
        Car car = new Car();
        int previousLocation;
        int currentLocation;

        for (int i = 0; i < ran.nextInt(10); i++) {
            goForward();
        }
        previousLocation = car.getLocation();

        car.move(value);
        currentLocation = car.getLocation();

        assertThat(currentLocation - previousLocation).isEqualTo(expected);
    }
}
