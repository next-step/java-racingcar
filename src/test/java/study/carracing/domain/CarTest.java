package study.carracing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9, 10})
    @DisplayName("random 값이 4이상일 경우 자동차가 1칸 전진한다.")
    void moveCar(int randomValue) {
        Car car = new Car(new RandomGeneratorImpl());

        car.go(randomValue);

        int position = car.getPosition();
        assertThat(position).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("random 값이 4미만일 경우 자동차는 움직이지 않는다.")
    void dontMoveCar(int randomValue) {
        Car car = new Car(new RandomGeneratorImpl());

        car.go(randomValue);

        int position = car.getPosition();
        assertThat(position).isEqualTo(1);
    }
}
