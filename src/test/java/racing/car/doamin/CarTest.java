package racing.car.doamin;

import org.junit.jupiter.api.Test;
import racing.car.domain.Car;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    void 초기값_0_테스트() {
        Car car = new Car("seou");
        assertThat(car).extracting("position").isEqualTo(0);
    }

}
