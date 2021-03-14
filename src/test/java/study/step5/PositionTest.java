package study.step5;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.step5.domain.Position;

public class PositionTest {

    @Test
    @DisplayName("Position 클래스 생성 테스트")
    void create() {
        Position position = new Position(3);
        assertThat(position).isEqualTo(new Position(3));
    }

    @Test
    @DisplayName("유효성 테스트")
    void valid() {
        assertThatThrownBy(() -> new Position(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("움직임 테스트")
    void move() {
        Position position = new Position(3);
        assertThat(position.move()).isEqualTo(new Position(4));
    }
}
