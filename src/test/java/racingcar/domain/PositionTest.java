package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PositionTest {

    @Test
    @DisplayName("위치 클래스 생성 테스트")
    void create() {
        Position position = new Position(3);
        assertThat(position).isEqualTo(new Position(3));
    }

    @Test
    @DisplayName("equalPosition 메소드 테스트")
    void equalPosition() {
        Position position = new Position(3);
        assertThat(position.equalPosition(3)).isTrue();
    }

    @Test
    @DisplayName("comparePosition 메소드 테스트")
    void comparePosition() {
        Position position = new Position(3);
        assertThat(position.comparePosition(4)).isEqualTo(4);
    }

    @Test
    @DisplayName("position 이동 테스트")
    void move() {
        Position position = new Position(4);
        assertThat(position.move()).isEqualTo(new Position(5));
    }
}
