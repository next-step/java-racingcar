package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Distance;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DistanceTest {
    @Test
    @DisplayName("distance 값이 같으면 같은 객체")
    public void equal() {
        assertThat(new Distance(1)).isEqualTo(new Distance(1));
        assertThat(new Distance(1).hashCode()).isEqualTo(new Distance(1).hashCode());
    }

    @Test
    @DisplayName("distance 값이 다르면 다른 객체")
    public void notEqual() {
        assertThat(new Distance(1)).isNotEqualTo(new Distance(2));
        assertThat(new Distance(1).hashCode()).isNotEqualTo(new Distance(2).hashCode());
    }
}