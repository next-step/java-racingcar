package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    @Test
    @DisplayName("자동차 전진 상태 생성 성공")
    void createPositionSuccess() {
        Position position = new Position(1);
        assertThat(position)
                .isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("음수 값을 넣어서 자동차 전진 상태 생성 실패")
    void createPositionFailByNegativeInput() {
        assertThatThrownBy(
                () -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차를 한 칸 전진시키는데 성공")
    void moveOnePositionSuccess() {
        Position position = new Position(2);
        Position newPosition = position.move();

        assertThat(newPosition.getPosition())
                .isEqualTo(3);
    }
}
