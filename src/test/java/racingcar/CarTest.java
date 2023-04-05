package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차 전진 테스트")
    void car_move_test() {
        Car car = new Car();
        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("0 에서 9 사이에서 random 값을 테스트한다.")
    void random_number_test() {
        Car car = new Car();
        int randomNumber = car.getRandomNumber();

        assertThat(randomNumber).isBetween(0, 9);
    }

    @Test
    @DisplayName("자동차 는 random 값이 4이상일 경우 전진한다.")
    void car_move_true_test() {
        Car car = new Car() {
            @Override
            protected int getRandomNumber() {
                return 4;
            }
        };
        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 는 random 값이 4 미만 일 경우 전진 하지 않은다.")
    void car_move_false_test() {
        Car car = new Car() {
            @Override
            protected int getRandomNumber() {
                return 3;
            }
        };
        car.move();

        assertThat(car.getPosition()).isZero();
    }
}