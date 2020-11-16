package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step5.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @DisplayName("숫자가 4미만 일 때 정지")
    @ValueSource(ints = {1, 2, 3})
    public void 자동차_정지(int value) {
        Car car = new Car("yura");
        car.move(value);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("숫자 4 이상 일 때 전진")
    @ValueSource(ints = {4, 5, 6, 7})
    public void 전진_테스트(int value) {
        Car car = new Car("hi");
        car.move(value);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
