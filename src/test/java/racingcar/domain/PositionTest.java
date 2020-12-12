package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @Test
    @DisplayName("자동차 위치 생성")
    void createPosition() {
        Position position = new Position();
        assertThat(position.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 위치 이동 추가")
    void addPosition() {
        Position position = new Position();
        position.add();
        assertThat(position.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 움직였는지")
    void isMovedPosition() {
        Position movePosition = new Position();
        movePosition.add();
        assertThat(movePosition.isMoved()).isTrue();

        Position stopPosition = new Position();
        assertThat(stopPosition.isMoved()).isFalse();
    }
}
