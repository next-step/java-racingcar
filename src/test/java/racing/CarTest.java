package racing;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


public class CarTest {
    @DisplayName("자동차는 5 자 이하의 이름을 가진다.")
    @Test
    public void name() {
        assertDoesNotThrow(() -> new Car("jason"));
    }

    @DisplayName("자동차는 5 자 이하의 이름을 가진다.")
    @Test
    public void in() {
     //   assertThatIllegalArgumentException().isThrownBy(() -> new Car());
    }

    @DisplayName("자동차는 움직일 수 있다.")
    @Test
    public void move() {
        Car car = new Car("jason");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차의 거리를 알 수 있다.")
    @Test
    public void position() {
        Car car = new Car("jason");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(0);
    }

}
