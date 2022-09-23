package racinggame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차가 이동할 수 있다.")
    void forward() {
        // given
        Car car = new Car();

        // when
        car.forward();
        int status = car.getStatus();

        // then
        Assertions.assertThat(status).isEqualTo(1);
    }
}