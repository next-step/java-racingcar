package racing.v1.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("자동차 생성시 초기 위치는 1 테스트")
    void step1() {
        assertThat(new Car().getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차가 한번 이동하면 위치는 2 테스트")
    void step2() {
        Car car = new Car();

        car.move();

        assertThat(car.getPosition()).isEqualTo(2);
    }
}
