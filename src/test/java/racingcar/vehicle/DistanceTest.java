package racingcar.vehicle;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("[Step4] 이동 거리")
class DistanceTest {

    @DisplayName("[성공] 생성")
    @ParameterizedTest
    @CsvSource(value = {
        "0", "99"
    })
    public void init(int initDistance) {
        // given

        // when
        Distance distance = new Distance(initDistance);

        // then
        assertThat(distance.get()).isEqualTo(initDistance);
    }

    @DisplayName("[실패] 생성 - 최소 값 보다 작은 초기 값")
    @ParameterizedTest
    @CsvSource(value = {
        "-1"
    })
    public void init_tooSmallDistance(int initDistance) {
        // given

        // when
        assertThrows(IllegalArgumentException.class, () -> new Distance(initDistance));

        // then
    }

    @DisplayName("[성공] VO 로 비교하기")
    @Test
    public void compare() {
        // given
        Distance sameDistance1 = new Distance(0);
        Distance sameDistance2 = new Distance(0);

        Distance differentDistance = new Distance(5);

        // when
        assertThat(System.identityHashCode(sameDistance1)).isNotEqualTo(System.identityHashCode(sameDistance2));
        assertThat(sameDistance1).isEqualTo(sameDistance2);
        assertThat(sameDistance1.hashCode()).isEqualTo(sameDistance2.hashCode());

        assertThat(sameDistance1).isNotEqualTo(differentDistance);
        assertThat(sameDistance2).isNotEqualTo(differentDistance);

        // then
    }
}
