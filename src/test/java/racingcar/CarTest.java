package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private static final int MOVABLE_NUMBER = 5;

    @Test
    @DisplayName("자동차가 움직이면 Position이 1 증가한다")
    void Car() {
        CarName carName = new CarName("hello");
        Car car = new Car(carName, new Position());
        car.play(MOVABLE_NUMBER);
        assertThat(car).isEqualTo(new Car(carName, new Position(1)));
    }

    @ParameterizedTest
    @CsvSource(value = {"hello:4:1", "hello:3:0"}, delimiter = ':')
    @DisplayName("자동차가 4 이상의 숫자를 받아야만 움직인다.")
    void move_test(String name, int number, int position) {
        Car car = new Car(new CarName(name));
        car.play(number);
        assertThat(car).isEqualTo(new Car(new CarName(name), new Position(position)));
    }
}
