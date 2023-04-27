package study.carrace.step3.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarPositionTest {
    @Test
    void add_move_statuses() {
        // given
        List<Boolean> moveStatuses = List.of(true, false, true);

        // when
        CarPosition carPosition = new CarPosition().addMoveStatus(moveStatuses);

        // then
        assertThat(carPosition)
                .isEqualTo(new CarPosition(List.of(true, false, true)));
    }
}