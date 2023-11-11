package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {

    @Test
    @DisplayName("자동차 position '-' 문자열 변경 테스트")
    void carPositionRepeatTest() {
        Car car = new Car(3);
        assertThat(car.getPositionRepeat()).isEqualTo("---");
    }

    @Test
    @DisplayName("자동차 이동 테스트")
    void carMoveTest() {
        Car car = new Car();
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(1);
    }

}
