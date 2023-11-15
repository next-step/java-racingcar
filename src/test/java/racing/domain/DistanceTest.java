package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DistanceTest {

    @Test
    void assertIsEqual() {
        Distance distance = new Distance(1);

        assertThat(distance.isEqual(1)).isTrue();
    }

    @Test
    void assertIsGreater() {
        Distance distance = new Distance(1);

        assertThat(distance.isGreater(0)).isTrue();
    }

    @Test
    void assertMaxNum() {
        Distance distance = new Distance(1);

        assertThat(distance.maxNum(2)).isEqualTo(2);
    }

    @Test
    void assertAddDistance() {
        Distance distance = new Distance(1);

        assertThat(distance.addDistance().value()).isEqualTo(2);
    }
}