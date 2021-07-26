package study.racing.domain;

import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class DistanceTest {

    @DisplayName("전진가능여부 판별값을 통해 거리1증가 테스트.")
    @Test
    void 거리1전진테스트() {
        Distance distance = new Distance();
        distance.move();
        assertThat(distance.getMoveDistance()).isEqualTo(1);
    }

    @DisplayName("전진한 거리가 비교값과 비교하여 더 큰값인지 확인하는 테스트.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void name(int input) {
        Distance distance1 = new Distance();
        IntStream.range(0, input + 1).forEach(i -> distance1.move());

        assertThat(distance1.getMaxValue(input)).isGreaterThan(input);
    }
}