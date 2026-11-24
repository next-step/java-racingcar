package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @DisplayName("자동차의 초기 위치는 0이다")
    @Test
    void initialPosition() {
        Car car = new Car();
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차가 전진하면 위치가 1 증가한다")
    @Test
    void move() {
        Car car = new Car();
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차는 이름을 가진다")
    @Test
    void hasName() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }
}
