package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {
    @Test
    @DisplayName("Position 가 객체의 동등성을 만족한다.")
    void createTest() {
        Position position = new Position(4);
        assertThat(position).isEqualTo(new Position(4));
    }
}
