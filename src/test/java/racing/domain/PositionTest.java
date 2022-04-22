package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    @Test
    void 생성자_문자열_인자_int_파싱() {
        assertThat(new Position("3")).isEqualTo(new Position(3));
    }

    @Test
    void Position_비교_참() {
        Position position = new Position(3);
        assertThat(position.equals(new Position(3))).isTrue();
    }

    @Test
    void Position_비교_거짓() {
        Position position = new Position(3);
        assertThat(position.equals(new Position(2))).isFalse();
    }

    @Test
    void Position_2추가후_비교검증() {
        Position position = new Position();
        position.move();
        position.move();
        assertThat(position).isEqualTo(new Position(2));
    }

    @Test
    void 생성자_Position_인자_2_추가후_비교검증() {
        Position position = new Position(2);
        assertThat(position).isEqualTo(new Position(2));
    }

    @Test
    void 음수일_경우_예외발생() {
        assertThatThrownBy(() -> new Position(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 값_10_초과_예외발생() {
        assertThatThrownBy(() -> new Position(10)).isInstanceOf(IllegalArgumentException.class);
    }
}
