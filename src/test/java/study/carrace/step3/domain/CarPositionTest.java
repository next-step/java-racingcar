package study.carrace.step3.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.carrace.step3.domain.exception.IllegalCarPositionIndex;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarPositionTest {
    @ParameterizedTest(name = "[{index}/2] 자동차 이동 상태 보관")
    @CsvSource({"true,true", "false,false"})
    void add_move_status(boolean moveStatus, boolean expectedMoveStatus) {
        // given
        CarPosition carPosition = new CarPosition();

        // when
        carPosition.addMoveStatus(moveStatus);

        // then
        assertThat(carPosition)
                .isEqualTo(new CarPosition(List.of(expectedMoveStatus)));
    }

    @ParameterizedTest(name = "[{index}/2] 자동차 이동 상태 반환")
    @CsvSource({"true,true", "false,false"})
    void is_moved_at(boolean moveStatus, boolean expectedMoveStatus) {
        // given
        CarPosition carPosition = new CarPosition();
        carPosition.addMoveStatus(moveStatus);

        // when, then
        assertThat(carPosition.isMovedAt(0))
                .isEqualTo(expectedMoveStatus);
    }

    @Test
    void invalid_is_moved_at() {
        // given
        CarPosition carPosition = new CarPosition(List.of(true));

        // when, then
        assertThatThrownBy(() -> carPosition.isMovedAt(1))
                .isInstanceOf(IllegalCarPositionIndex.class)
                .hasMessage("특정 시점의 자동차 이동 여부 조회 시, 자동차 이동 시도 횟수(1)보다 작은 값을 인덱스로 사용해야 합니다: 1");
    }

    @Test
    void number_of_move() {
        // given
        CarPosition carPosition = new CarPosition(List.of(true, false, true));

        // when, then
        assertThat(carPosition.numberOfMove()).isEqualTo(2);
    }
}