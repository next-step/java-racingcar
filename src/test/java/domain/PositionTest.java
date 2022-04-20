package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

class PositionTest {

    @DisplayName("포지션 이동 테스트")
    @Test
    void goForwardTest() {
        Position position = new Position();
        position.goForward();

        Position afterPosition = new Position();
        ReflectionTestUtils.setField(afterPosition, "position", 1);

        Assertions.assertThat(position.equals(position)).isTrue();
    }
}