package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestCarDistance {
    @Test
    void create() {
        CarDistance distance = new CarDistance();
        assertThat(distance).isInstanceOf(CarDistance.class);
        assertThat(distance.getDistance()).isEqualTo(0);
        assertThat(distance).isEqualTo(new CarDistance());
    }

    @Test
    void create_with_distance() {
        CarDistance distance = new CarDistance(5);
        assertThat(distance).isEqualTo(new CarDistance(5));
    }

    @Test
    void increase() {
        CarDistance distance = new CarDistance();
        distance.increase();
        assertThat(distance).isEqualTo(new CarDistance(1));
    }
}
