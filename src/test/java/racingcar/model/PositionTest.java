package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {
    @Test
    @DisplayName("더 큰 position 반환")
    public void 더_큰_position() {
        Position position = new Position(5);
        Assertions.assertThat(position.biggerPosition(10))
                .isEqualTo(10);
        Assertions.assertThat(position.biggerPosition(3))
                .isEqualTo(5);
    }

    @Test
    @DisplayName("동일한 position 확인")
    public void 동일_position() {
        Position position = new Position(3);
        Assertions.assertThat(position.matchPosition(3))
                .isTrue();
        Assertions.assertThat(position.matchPosition(7))
                .isFalse();
    }

}
