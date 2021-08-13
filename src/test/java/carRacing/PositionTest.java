package carRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    @DisplayName("Position 객체 생성 유효성 테스트")
    void initPosition() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Position(-1));
    }

    @Test
    @DisplayName("포지션 값이 잘 늘어나는지 테스트")
    void move() {
        Position position = new Position(1);
        assertThat(position.move()).isEqualTo(new Position(2));
    }

    @Test
    @DisplayName("포지션 값의 대소 비교를 잘 하는지 테스트")
    void max() {
        Position small = new Position(10);
        Position big = new Position(100);
        assertThat(small.max(big)).isEqualTo(big);
    }

    @Test
    @DisplayName("포지션을 문자열로 잘 나타내는지 테스트")
    void toStringPosition() {
        Position position = new Position(4);
        assertThat(position.toStringPosition()).isEqualTo("----");
    }
}