package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PositionTest {

    @DisplayName("자동차의 기본 위치는 1(한 칸)이다")
    @Test
    void defaultPosition() {
        Position position = new Position();

        assertThat(position.getValue()).isEqualTo(1);
    }

    @DisplayName("Position 은 불변객체:moveForward 호출 시 값이 1 증가한 새로운 객체를 반환한다")
    @Test
    void moveForward() {
        Position origin = new Position();
        Position moved = origin.moveForward();

        assertThat(origin.getValue()).isNotEqualTo(moved.getValue());
        assertThat(moved).isNotSameAs(origin);
    }

    @DisplayName("Position 값(value)이 같으면 같은 객체로 판단된다")
    @Test
    void logicalEqualityPosition() {
        Position a = new Position();          // value = 1
        Position b = new Position();          // value = 1

        assertThat(a.getValue()).isEqualTo(b.getValue());
        assertThat(a).isEqualTo(b);
        assertThat(a.hashCode()).isEqualTo(b.hashCode());
    }
}