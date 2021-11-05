package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    @Test
    @DisplayName("차 전진 테스트")
    void forwardTest(){
        Car car = new Car();
        car.forward(1);
        assertThat(car.getPosition()).isEqualTo(1);
        car.forward(2);
        assertThat(car.getPosition()).isEqualTo(3);
    }
}
