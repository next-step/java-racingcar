package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class CarTest {
    private static final int MOVABLE_NUMBER = 5;
    @Test
    @DisplayName("자동차가 움직이면 Position이 1 증가한다")
    void Car () {
        Car car = new Car(new Position());
        car.play(MOVABLE_NUMBER);
        assertThat(car).isEqualTo(new Car(new Position(1)));
    }

    @ParameterizedTest
    @CsvSource(value ={"4:1","3:0"}, delimiter = ':')
    @DisplayName("자동차가 4 이상의 숫자를 받아야만 움직인다.")
    void move_test(int number, int position) {
        Car car = new Car();
        car.play(number);
        assertThat(car).isEqualTo(new Car(new Position(position)));
    }
}
