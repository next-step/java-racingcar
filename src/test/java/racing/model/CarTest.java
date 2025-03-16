package racing.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car();
    }

    @DisplayName("자동차의 위치를 한 칸 증가시킬 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    void carMoveTest(int argument) {
        car.move(argument);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("파라미터로 받는 숫자가 4 미만인 경우 자동차는 멈춘다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    void carNotMoveTest(int argument) {
        car.move(argument);

        assertThat(car.getPosition()).isEqualTo(0);
    }

}
