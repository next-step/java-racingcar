package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarPositionTest {

    @Test
    @DisplayName("자동차 이동시 위치값이 증가한다.")
    public void carPositionPlus() {
        CarPosition carPosition = new CarPosition(1);
        carPosition.positionPlus(1);
        assertThat(carPosition.value()).isEqualTo(2);
    }

}
