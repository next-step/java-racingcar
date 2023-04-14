package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("숫자가 4보다 작으면 false를 반환한다")
    @Test
    void when_number_is_less_than_four() {
        // given
        int number = 3;

        // when
        boolean actualResult = Car.isMovable(number);

        // then
        assertThat(actualResult).isFalse();
    }

    @DisplayName("숫자가 4이면 true를 반환한다")
    @Test
    void when_number_is_four() {
        // given
        int number = 4;

        // when
        boolean actualResult = Car.isMovable(number);

        // then
        assertThat(actualResult).isTrue();
    }

    @DisplayName("숫자가 4보다 크면 true를 반환한다")
    @Test
    void when_number_is_greater_than_four() {
        // given
        int number = 5;

        // when
        boolean actualResult = Car.isMovable(number);

        // then
        assertThat(actualResult).isTrue();
    }

    @DisplayName("움직이지 않으면 모양이 없다")
    @Test
    void blank_when_car_does_not_move() {
        // given
        Car car = new Car();

        // when

        // then
        assertThat(car.toString()).isEqualTo("");
    }

    @DisplayName("한번 움직이면 -이 출력된다")
    @Test
    void shape_once_when_car_move_once() {
        // given
        Car car = new Car();

        // when
        car.move();

        // then
        assertThat(car.toString()).isEqualTo("-");
    }

    @DisplayName("두번 움직이면 --이 출력된다.")
    @Test
    void shape_twice_when_car_move_twice() {
        // given
        Car car = new Car();

        // when
        car.move();
        car.move();

        // then
        assertThat(car.toString()).isEqualTo("--");
    }
}