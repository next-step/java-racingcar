package step3.position;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    @DisplayName("포지션은 한 칸 이동할 수 있다.")
    void a() {
        final Position sut = new CarPosition(0);

        final Position positionMovedOneSpace = sut.movedPosition();

        assertThat(positionMovedOneSpace).isEqualTo(new CarPosition(1));
    }

    @Test
    @DisplayName("포지션 위치를 반환할 수 있다.")
    void b() {
        final Position sut = new CarPosition(0);

        assertThat(sut.position()).isZero();
    }

}
