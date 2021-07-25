package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @DisplayName("입력 위치 값이 0 이하의 값이면 IllegalArgumentException 발생")
    @Test
    void create_ThrowsIllegalArgumentException_IfDistanceIsUnderZero() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(
                () -> new Position(-1)
        );
    }

    @DisplayName("move 테스트")
    @Test
    void move() {
        Position position = new Position();
        assertThat(position.move()).isEqualTo(new Position(1));
    }
}
