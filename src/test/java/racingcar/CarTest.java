package racingcar;

import static org.assertj.core.api.Java6Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;

public class CarTest {

    @Test
    @DisplayName("자동차 이름이 5글자가 초과하면 IllegalException이 발생한다.")
    void 이름길이가_5글자_초과() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car("wooooni");
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 8, 9})
    @DisplayName("랜덤값이 4이상일 경우 자동차는 전진한다.")
    void 자동차_전진(int randomNumber) {
        Car car = new Car("wooni");
        car.moveForward(randomNumber);
        assertThat(car.getPosition()).isEqualTo("-");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3})
    @DisplayName("랜덤값이 4미만일 경우 자동차는 정지한다.")
    void 자동차_정지(int randomNumber) {
        Car car = new Car("wooni");
        car.moveForward(randomNumber);
        assertThat(car.getPosition()).isEqualTo("");
    }
}

