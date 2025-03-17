package racingcar;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    @Test
    @Description("자동차를 한 번 움직인 경우 위치가 1 증가해야 함")
    void move() {
        Car car = new Car(0);
        car.move();
        assertThat(car.getCarLocation()).isEqualTo(1);
    }
}