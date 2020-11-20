package racingcar.view.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.input.RacingCount;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingCountTest {

    @Test
    @DisplayName("레이싱 횟수가 양수가 아니면, IllegalArgumentException을 던진다")
    void should_throw_Illegal_argument_exception_when_racing_count_is_negative_quantity() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingCount(-1))
                .withMessage("racing count is not available");
    }

}
