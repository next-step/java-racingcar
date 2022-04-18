package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    @DisplayName("move를 3번 호출한 Position과 new Position(3)은 같다. ")
    void 포지션_테스트 () {
        Position position = new Position();

        int moveCount = 3;
        for (int i = 0; i < moveCount; i++) {
            position = position.move();
        }

        assertThat(position).isEqualTo(new Position(3));
    }
}
