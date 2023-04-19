package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @ParameterizedTest(name = "랜덤값 0 ~ 9을 받아서 4이상의 값일 때 true, 아닐때 false")
    @ValueSource(ints = {1, 4, 5, 9})
    void isMoveForward_checkMoveForward(int number) {
        car.move(number);
        if (number >= 4) {
            assertThat(car.distanceDriven()).isGreaterThan(0);
            return;
        }
        assertThat(car.distanceDriven()).isEqualTo(0);
    }

}
