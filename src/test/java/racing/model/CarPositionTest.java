package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarPositionTest {

    @Test
    @DisplayName("전진")
    void forward() {
        CarPosition carPosition = new CarPosition(0);
        carPosition.forward();
        assertThat(carPosition.getPosition()).isEqualTo(1);
    }
}