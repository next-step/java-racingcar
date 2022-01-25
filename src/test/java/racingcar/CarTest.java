package racingcar;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Java6Assertions.assertThat;

import java.util.Arrays;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;

public class CarTest {

    @Test
    void 이름길이() {
        Car car = new Car("wooooni");

        assertThatIllegalArgumentException()
            .isThrownBy((ThrowingCallable) car);
    }

    @ParameterizedTest
    @ValueSource(ints = {4,8,9})
    @DisplayName("4이상일 경우 전진")
    void 전진(int randomNumber) {
        Car car = new Car("wooni");
        car.moveForward(randomNumber);
        assertThat(car.getPosition()).isEqualTo("-");
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,3})
    @DisplayName("4미만일 경우 정지")
    void 정지(int randomNumber) {
        Car car = new Car("wooni");
        car.moveForward(randomNumber);
        assertThat(car.getPosition()).isEqualTo("");
    }
}

