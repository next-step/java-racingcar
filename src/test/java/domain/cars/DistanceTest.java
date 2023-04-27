package domain.cars;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import domain.cars.Distance;

public class DistanceTest {

    @Test
    void getDistance() {
        Distance distance = new Distance(3);
        assertThat(distance.getDistance()).isEqualTo(3);
    }
}
