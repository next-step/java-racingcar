package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @DisplayName("자동차는 전진할 수 있다.")
    @Test
    void car_move_success() {
        // given
        final int FOUR = 4;
        Car car = new Car();
        assertThat(car.getPosition()).isZero();

        // when
        car.move(FOUR);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차는 정지할 수 있다.")
    @Test
    void car_stop_success() {
        // given
        Car car = new Car();
        assertThat(car.getPosition()).isZero();

        // when
        car.move(0);
        assertThat(car.getPosition()).isZero();
    }

    @DisplayName("자동차는 0-9 사이의 값중 4이상의 값이 들어올 때 전진한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    void car_move_when_input_more_than_4(int input, int result) {
        // given
        Car car = new Car();

        // when
        car.move(input);

        // then
        assertThat(car.getPosition())
                .isEqualTo(result);
    }

    @DisplayName("0~3 사이의 랜덤값 설정으로는 자동차가 항상 정지한다.")
    @Test
    void car_stop_when_random_bound_to_3() {
        // given
        Car car = new Car();
        CarMoveStrategy carMoveStrategy = new CarMoveStrategy(new Random());

        // when
        int result = carMoveStrategy.getResult(3);
        car.move(result);

        // then
        assertThat(car.getPosition()).isZero();
        assertThat(result).isLessThan(4);
    }

}
