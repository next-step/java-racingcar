package racing.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarPositionTest {

    @Test
    void 맥스() {
        CarPosition carPosition = new CarPosition(10);
        assertThat(carPosition.max(15)).isEqualTo(15);
        assertThat(carPosition.max(5)).isEqualTo(10);
    }

    @Test
    void 위치_확인() {
        CarPosition carPosition = new CarPosition(10);
        assertThat(carPosition).isEqualTo(new CarPosition(10));
        assertThat(carPosition).isNotEqualTo(new CarPosition(15));
    }

    @Test
    void 전진_확인() {
        CarPosition carPosition = new CarPosition(10);
        carPosition.progress();
        assertThat(carPosition).isEqualTo(new CarPosition(11));
    }


}
