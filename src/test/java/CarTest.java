import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("랜덤 변수가 4이상이면 차가 한 칸 움직인다.")
    void carMovesOneStepIfRandomNumberIsGreaterThanEqual4() {
        for (int i = 0; i < 4; i++) {
            Car car = new Car();
            car.move(i);
            assertThat(car.getPosition()).isEqualTo(0);
        }
        for (int i = 4; i < 10; i++) {
            Car car = new Car();
            car.move(i);
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("자동차를 움직이는 변수는 0에서 9사이의 값이다.")
    void carMoveVariableIsBetween0And9() {
        Car car = new Car();
        assertThrows(IllegalArgumentException.class, () -> car.move(-1));
        assertThrows(IllegalArgumentException.class, () -> car.move(10));
    }
}
