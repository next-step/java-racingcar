package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("moveForward() 메서드 파라미터가 true 면 location 한 칸 증가한다")
    void move_when_isMove_true() {
        Car car = new Car("suchan");
        car.moveForward(true);
        assertThat(car.getLocation()).isEqualTo(1);
    }
}