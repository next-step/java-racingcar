package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DistanceTest {

    @Test
    void create() {
        Distance distance = new Distance(0);
        assertThat(distance).isEqualTo(new Distance(0));
        assertThat(distance).isEqualTo(new Distance("0"));
    }

    @Test
    void findLongestDistance() {
        Distance distance = new Distance(4);
        assertThat(distance.findLongestDistance(5)).isEqualTo(5);
        assertThat(distance.findLongestDistance(3)).isEqualTo(4);
    }

    @Test
    void isLongestDistance() {
        Distance distance = new Distance(4);
        assertThat(distance.isLongestDistance(4)).isTrue();
        assertThat(distance.isLongestDistance(5)).isFalse();
    }
}