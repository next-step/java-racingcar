package racinggame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {
    private int DEFAULT_POSITION = 1;

    @Test
    void 생성후_기본위치() {
        Car car = new Car();
        Assertions.assertThat(car.getPosition()).isEqualTo(DEFAULT_POSITION);
    }

    @Test
    void move_호출시_위치_1만큼_이동() {
        Car car = new Car();
        car.move();
        Assertions.assertThat(car.getPosition()).isEqualTo(DEFAULT_POSITION + 1);
    }
}
