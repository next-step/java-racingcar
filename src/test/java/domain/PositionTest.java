package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {
    @Test
    @DisplayName("value 값과 함께 position을 생성하면 position의 값이 4로 설정된다.")
    void create() {
        Position position = new Position(4);
        Assertions.assertThat(position.getValue()).isEqualTo(4);
    }
}
