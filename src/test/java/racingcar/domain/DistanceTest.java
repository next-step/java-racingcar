package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DistanceTest {
    @Test
    @DisplayName("이동거리확인")
    void 이동거리확인() {
        Distance distance = new Distance(4);

        Assertions.assertThat(distance.isEqualTo(4)).isTrue();
    }

    @Test
    @DisplayName("이동")
    void 이동() {
        Distance distance = new Distance(2);

        distance.move();

        Assertions.assertThat(distance.isEqualTo(3)).isTrue();
    }
}
