package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    void 자동차_이동기준값이상입력(int number) {
        Car car = new Car();
        car.move(number);
        assertThat(car.getPosition()).isEqualTo(Car.SET_POSITION + 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void 자동차_이동기준값미만입력(int number) {
        Car car = new Car();
        car.move(number);
        assertThat(car.getPosition()).isEqualTo(Car.SET_POSITION);
    }

    @Test
    void 자동차_초기화() {
        assertThat(new Car().getPosition()).isEqualTo(Car.SET_POSITION);
    }

}
