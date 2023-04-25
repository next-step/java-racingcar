package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Position;

public class PositionTest {

    @Test
    @DisplayName("위치는 음수값을 가질 수 없으므로 예외를 던진다.")
    public void validate_Negative_ThrowException() {
        Assertions.assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
