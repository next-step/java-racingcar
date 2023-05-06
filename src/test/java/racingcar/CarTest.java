package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    @DisplayName("자동차가 정지한다.")
    void testNonMove(int number) {
        Car car = new Car("test");
        car.move(number);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    @DisplayName("자동차가 전진한다.")
    void testMove(int number) {
        Car car = new Car("test");
        car.move(number);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:0", "4:1"}, delimiter = ':')
    @DisplayName("자동차의 위치를 가져온다.")
    void testGetPosition(int number, int expected) {
        Car car = new Car("test");
        car.move(number);
        assertThat(car.getPosition()).isEqualTo(expected);
    }
}
