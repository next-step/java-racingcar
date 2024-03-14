package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    @DisplayName("이동 기능 - 전진 테스트")
    void mvoe(){
        Car car = new Car();
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(Position.create().move());
    }

    @Test
    @DisplayName("이동 기능 - 멈춤 테스트")
    void stop(){
        Car car = new Car();
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo(Position.create());
    }
}