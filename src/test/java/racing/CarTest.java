package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.entity.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @ParameterizedTest
    @CsvSource(value = {"1:2", "2:3", "3:4"}, delimiter = ':')
    @DisplayName("Car 의 이동한 횟수에 맞춰 현재 위치가 반영된다.")
    public void print_car_currentPosition(int moveCount, int expected) {
        // given
        Car car = new Car();

        // when
        for (int i = 0; i < moveCount; i++) {
            car.move();
        }

        // then
        int actual = car.getPosition();
        assertThat(actual).isEqualTo(expected);
    }
}