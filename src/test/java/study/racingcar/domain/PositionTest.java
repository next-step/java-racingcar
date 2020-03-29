package study.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @DisplayName("생성시 넘겨준 값을 변경 없이 그대로 유지할 수 있다.")
    @Test
    void value() {
        Position position = new Position(1);
        assertThat(position.getPosition()).isEqualTo(1);
    }

    @DisplayName("생성시 넘겨준 position 값이 같다면 같은 객체이다.")
    @Test
    void compareTest() {
        Position position = new Position(1);
        assertThat(position.equals(new Position(1))).isTrue();
    }
}
