package step3.study.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.study.util.FixedNumberGenerator;
import step3.study.util.NumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("4미만의 숫자에서는 자동차가 움직이지 않는다.")
    void notMoveCar(int num) {
        Car car = new Car(new Position(0));
        NumberGenerator fixedNumberGenerator = new FixedNumberGenerator(num);
        car.move(fixedNumberGenerator);
        assertThat(car.position()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("4이상의 숫자에서는 자동차가 움직인다.")
    void moveCar(int num) {
        Car car = new Car(new Position(0));
        NumberGenerator fixedNumberGenerator = new FixedNumberGenerator(num);
        car.move(fixedNumberGenerator);
        assertThat(car.position()).isEqualTo(1);
    }
}
