package CarRacing.domain;

import CarRacing.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    @Test
    @DisplayName("위치에 음수 입력 시 IllegalArgumentException 발생")
    public void position_negative() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("위치에 양수 입력 시 해당 값으로 셋팅")
    public void position_positive() {
        int input = 3;

        int expected = 3;
        int actual = new Position(input).currentPosition();
        assertThat(actual).isEqualTo(expected);
    }
}
