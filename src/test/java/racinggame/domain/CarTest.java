package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차 이름과 현재 위치가 동일하다면, 자동차는 같아야 한다.")
    @Test
    void equalsAndHashCode() {
        assertThat(new Car("car", 1)).isEqualTo(new Car("car", 1));
    }

    @DisplayName("자동차가 전진하면 위치가 1 증가한다.")
    @Test
    void move() {
        Car car = new Car("car");
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

}
