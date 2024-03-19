package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    @DisplayName("이동 기능 - 전진 테스트")
    void mvoe(){
        Car car = new Car("test");
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(Position.create().move());
    }

    @Test
    @DisplayName("이동 기능 - 멈춤 테스트")
    void stop(){
        Car car = new Car("test");
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo(Position.create());
    }

    @Test
    @DisplayName("최대_위치_찾기_테스트")
    void max_position(){
        Car car = new Car("test");
        Car car2 = new Car("test2");

        car.move(() -> true);

        assertThat(car.getMaxPosition(car2.getPosition())).isEqualTo(Position.create().move());
    }
}