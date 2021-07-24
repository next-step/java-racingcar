package racingcargame.domain.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcargame.domain.common.exception.InvalidInitDistanceException;

@DisplayName("이동 거리")
class DistanceTest {

    @DisplayName("[성공] 생성")
    @ParameterizedTest
    @CsvSource(value = {
        "0", "99"}
    )
    public void init(int initDistance) {
        // given

        // when
        Distance distance = new Distance(initDistance);

        // then
        Distance expectedDistance = new Distance(initDistance);
        assertThat(distance).isEqualTo(expectedDistance);
    }

    @DisplayName("[실패] 생성 - 최소 값 보다 작은 초기 값")
    @ParameterizedTest
    @CsvSource(value = {
        "-1"}
    )
    public void init_tooSmallDistance(int initDistance) {
        // given

        // when
        assertThrows(InvalidInitDistanceException.class, () -> new Distance(initDistance));

        // then
    }

    @DisplayName("[성공] 전진")
    @ParameterizedTest
    @CsvSource(value = {
        "0", "99"}
    )
    public void forword(int distance) {
        // given
        Distance initDistance = new Distance(0);
        Distance forwordDistance = new Distance(distance);

        // when
        Distance destinationDistance = initDistance.forward(forwordDistance);

        // then
        Distance expectedDistance = new Distance(initDistance.getValue() + forwordDistance.getValue());
        assertThat(destinationDistance).isEqualTo(expectedDistance);
    }

    @DisplayName("[성공] 비교 - 동등성")
    @Test
    public void compare_equality() {
        // given
        Distance sameDistance1 = new Distance(0);
        Distance sameDistance2 = new Distance(0);

        Distance differentDistance = new Distance(5);

        // when

        // then
        assertThat(sameDistance1).isEqualTo(sameDistance2);

        assertThat(sameDistance1).isNotEqualTo(differentDistance);
        assertThat(sameDistance2).isNotEqualTo(differentDistance);
    }

    @DisplayName("[성공] 비교 - 대소")
    @Test
    public void compare_largeAndSmall() {
        // given
        Distance distance0 = new Distance(0);
        Distance distance4 = new Distance(4);
        Distance distance15 = new Distance(15);
        Distance distance99 = new Distance(99);

        // when

        // then
        assertThat(distance0).isLessThan(distance4);
        assertThat(distance0).isLessThan(distance15);
        assertThat(distance0).isLessThan(distance99);

        assertThat(distance99).isGreaterThan(distance0);
        assertThat(distance99).isGreaterThan(distance4);
        assertThat(distance99).isGreaterThan(distance15);
    }
}
