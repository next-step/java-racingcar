package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("숫자가 4보다 작으면 움직이지 않는다.")
    @Test
    void keep_position_when_number_is_less_than_four() {
        // given
        final Car car = new Car();
        // when
        car.move(3);
        // then
        assertThat(car.toString()).isEqualTo("");
    }

    @DisplayName("숫자가 4와 같으면 한칸 움직인다.")
    @Test
    void keep_position_when_number_is_four() {
        // given
        final Car car = new Car();
        // when
        car.move(4);
        // then
        assertThat(car.toString()).isEqualTo("-");
    }

    @DisplayName("숫자가 4보다 크면 한칸 움직인다.")
    @Test
    void keep_position_when_number_is_greater_than_four() {
        // given
        final Car car = new Car();
        // when
        car.move(5);
        // then
        assertThat(car.toString()).isEqualTo("-");
    }
}