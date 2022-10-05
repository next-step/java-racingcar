package step3and4.game.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    @DisplayName("포지션은 한 칸 이동할 수 있다.")
    void a() {
        final Position sut = new Position(0);

        final Position positionMovedOneSpace = sut.movedPosition();

        assertThat(positionMovedOneSpace).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("포지션 위치를 출력할 수 있다.")
    void b() {
        final Position sut = new Position(1);

        assertThat(sut).hasToString("-");
    }

}
