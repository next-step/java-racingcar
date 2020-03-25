package step4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("soojung", "");
    }

    @DisplayName("자동차가 전진한다")
    @Test
    void forwardCar() {
        String forward = car.forwardStatus(8);
        assertThat(forward).isEqualTo("-");
    }

    @DisplayName("자동차가 움직이지 않는다")
    @Test
    void stopCar() {
        String stop = car.forwardStatus(3);
        assertThat(stop).isEqualTo("");
    }

}
