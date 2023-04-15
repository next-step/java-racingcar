package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차의 이동조건이 4이상일때 이동")
    void 자동차_이동() {
        Car car = new Car();
        int 전진 = 5;
        car.assignMovementCondition(전진);
        car.move();
        assertThat(car.distanceToDash().length()).isEqualTo(1);

    }

    @Test
    @DisplayName("자동차의 이동조건이 4미만일때 이동하지 않는다.")
    void 자동차_정지() {
        Car car = new Car();
        int 정지 = 3;
        car.assignMovementCondition(정지);
        car.move();
        assertThat(car.distanceToDash().length()).isEqualTo(0);

    }

}