package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DistanceTest {

    @Test
    @DisplayName("같은 이동거리는 같다")
    void 같은_이동거리는_같다() {
        assertThat(new Distance(1)).isEqualTo(new Distance(1));
        assertThat(new Distance(1)).isNotEqualTo(new Distance(2));
    }
}
