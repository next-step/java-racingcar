package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidCarSettingException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    @Test
    @DisplayName("Position 0 입력 테스트")
    void 위치_설정_성공_테스트() {
        Position position = new Position(0);
        assertThat(position.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("Position 음수 입력 테스트")
    void 위치_음수_설정_실패_테스트() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(InvalidCarSettingException.class)
                .hasMessage("자동차 위치는 음수값을 가질수 없습니다.");
    }
}
