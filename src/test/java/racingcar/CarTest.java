package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("자동차가 생성된다")
    @Test
    void createCar() {
        Car car = new Car();
        assertThat(car).isNotNull();
    }

    @DisplayName("자동차는 한 칸씩 전진한다")
    @Test
    void moveCar() {
        Car car = new Car();
        car.move();
        assertThat(car.position()).isOne();
    }

    @DisplayName("값이 4 이상일 때 자돋차가 이동한다")
    @ParameterizedTest
    @CsvSource({"0,0", "3,0", "4,1", "5,1"})
    void canMoveWhenAtLeast(int number, int expected) {
        Car car = new Car();
        car.moveIfPossible(number);
        assertThat(car.position()).isEqualTo(expected);
    }
}
