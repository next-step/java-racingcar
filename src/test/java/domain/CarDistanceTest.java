package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarDistanceTest {

    @DisplayName("자동차 이동거리 테스트")
    @Test
    public void moveDistanceTest() {
        CarDistance carDistance = new CarDistance();
        carDistance.addCarDistance(1);
        assertThat(carDistance.readCarDistance()).isEqualTo(1);
    }

}