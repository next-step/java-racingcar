package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @BeforeEach
    public void createCar() {
        car = new Car();
    }

    @Test
    @DisplayName("4 이상의 숫자가 나왔을 때 자동차 움직임 테스트")
    public void moveTest() {
        car.move(true);
        assertThat(car.getDisplacement()).isEqualTo("-");
    }

    @Test
    @DisplayName("4 미만의 숫자가 나왔을 때 자동차 움직임 테스트")
    public void doNotMoveTest() {
        car.move(false);
        assertThat(car.getDisplacement()).isEmpty();
    }
}
