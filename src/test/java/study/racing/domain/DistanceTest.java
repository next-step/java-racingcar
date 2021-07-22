package study.racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DistanceTest {

    @DisplayName("전진가능여부 판별값을 통해 거리1증가 테스트.")
    @Test
    void 거리1전진테스트() {
        Distance distance = new Distance();
        distance.move();
        assertThat(distance.getMoveDistance()).isEqualTo(1);
    }
}