package fourstep;

import fourstep.logic.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class CarTest {

    @Test
    @DisplayName("차 이동 테스트")
    void moveTest() {
        Car car = new Car("busung");
        car.move(4);
        assertThat(car.getLocation()).isEqualTo(1);
    }
}
