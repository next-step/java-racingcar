package racinggame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private int DEFAULT_POSITION = 1;
    private String carName = "실험자동차";

    @Test
    void 생성후_기본위치() {
        Car car = new Car(carName);
        assertThat(car.getPosition()).isEqualTo(DEFAULT_POSITION);
    }

    @Test
    void 자동차는_주어진_이름으로_생성됨() {
        Car car = new Car(carName);
        assertThat(car.getCarName()).isEqualTo(carName);
    }

    @Test
    void move_호출시_위치_1만큼_이동() {
        Car car = new Car(carName);
        car.move();
        assertThat(car.getPosition()).isEqualTo(DEFAULT_POSITION + 1);
    }
}
