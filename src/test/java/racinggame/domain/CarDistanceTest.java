package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarDistanceTest {

    @Test
    void create() {
        CarDistance carDistance = new CarDistance(5);
        assertThat(carDistance).isEqualTo(new CarDistance(5));
    }

    @Test
    void plus() {
        CarDistance carDistance = new CarDistance(5);
        assertThat(carDistance.plus()).isEqualTo(new CarDistance(6));
    }
}