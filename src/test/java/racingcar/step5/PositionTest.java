package racingcar.step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.step5.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    @Test
    @DisplayName("Position 생성 테스트")
    void createTest() {
        Position position = new Position(0);
        assertThat(position).isEqualTo(new Position(0));
    }

    @Test
    @DisplayName("Position 음수값 검증")
    void validation() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("위치값 증가")
    void addPosition() {
        Position position = new Position(0);
        position.addPosition();
        assertThat(position).isEqualTo(new Position(1));
    }

}
