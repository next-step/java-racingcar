package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class DistanceTest {

    @Test
    @DisplayName("거리가 추가되는지 테스트")
    public void addDistance() {
        // given
        Distance distance = new Distance(0);

        // when
        distance.addDistance(1);

        // then
        assertThat(distance.getDistance()).isEqualTo(1);
    }
}