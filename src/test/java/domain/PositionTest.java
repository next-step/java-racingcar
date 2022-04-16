package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @DisplayName("포지션 이동 테스트")
    @Test
    void goForwardTest() {
        Position position = new Position();
        int beforePosition = position.getPosition();
        position.goForward();
        Assertions.assertThat(position.getPosition()).isEqualTo(beforePosition + 1);
    }
}