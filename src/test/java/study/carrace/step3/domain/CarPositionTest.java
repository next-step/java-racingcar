package study.carrace.step3.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.carrace.step3.domain.exception.IllegalCarPositionIteration;

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

    @Test
    void number_of_move() {
        // given
        CarPosition carPosition = new CarPosition(List.of(true, false, true));

        // when, then
        assertThat(carPosition.numberOfMove()).isEqualTo(2);
    }

    @ParameterizedTest(name = "[{index}/3] 특정 시점에서 자동차 위치 반환")
    @CsvSource({"1,-", "2,-", "3,--"})
    void position_at(int iteration, String expectedPosition) {
        // given
        CarPosition carPosition = new CarPosition(List.of(true, false, true));

        // when, then
        assertThat(carPosition.positionAt(iteration)).isEqualTo(expectedPosition);
    }

    @Test
    void position_at_invalid_iteration() {
        // given
        CarPosition carPosition = new CarPosition(List.of(true, false, true));

        // when, then
        assertThatThrownBy(() -> carPosition.positionAt(4))
                .isInstanceOf(IllegalCarPositionIteration.class)
                .hasMessage("자동차 위치 관련 조회 시, 자동차 이동 시도 횟수(3) 이하의 시도 순서를 인덱스로 사용해야 합니다: 4");
    }
}