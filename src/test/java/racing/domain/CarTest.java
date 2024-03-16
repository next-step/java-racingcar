package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("random 값 >= 4일 경우 전진할 수 있다")
    void go_forward_test() {
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car.getPosition() > 1);
    }

    @Test
    @DisplayName("위치 최댓값을 구할 수 있다")
    void max_position() {
        Car car = new Car("pobi", 5);
        assertThat(car.max(3)).isEqualTo(5);
        assertThat(car.max(10)).isEqualTo(10);
    }

    @Test
    @DisplayName("최댓값과 일치 여부를 판별할 수 있다")
    void match_max_postiion() {
        Car car = new Car("pobi", 5);
        assertThat(car.max(3)).isEqualTo(5);
        assertThat(car.isMatch(5));
    }

}
