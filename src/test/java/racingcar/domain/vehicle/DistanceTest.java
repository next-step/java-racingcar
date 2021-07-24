package racingcar.domain.vehicle;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.common.exception.InvalidInitDistanceException;
import racingcar.common.exception.InvalidMoveDistanceException;

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
        assertThat(distance.getValue()).isEqualTo(initDistance);
    }

    @DisplayName("[실패] 생성 - 최소 값 보다 작은 초기 값")
    @ParameterizedTest
    @CsvSource(value = {
        "-1"
    })
    public void init_tooSmallDistance(int initDistance) {
        // given

        // when
        assertThrows(InvalidInitDistanceException.class, () -> new Distance(initDistance));

        // then
    }

    @DisplayName("[성공] 이동")
    @ParameterizedTest
    @CsvSource(value = {
        "0", "99"
    })
    public void move(int moveDistance) {
        // given

        // when
        Distance distance = new Distance(0).move(moveDistance);

        // then
        assertThat(distance).isEqualTo(new Distance(moveDistance));
    }

    @DisplayName("[실패] 이동 - 최소 값 보다 입력 값")
    @ParameterizedTest
    @CsvSource(value = {
        "-1"
    })
    public void move_tooSmallDistance(int moveDistance) {
        // given
        Distance distance = new Distance(0);

        // when
        assertThrows(InvalidMoveDistanceException.class, () -> distance.move(moveDistance));

        // then
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
