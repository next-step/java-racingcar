package step3.position;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("포지션은 한 칸 이동할 수 있다.")
    void a() {
        final Position sut = new CarPosition(0);

        final Position positionMovedOneSpace = sut.movedPosition();

        Assertions.assertThat(positionMovedOneSpace).isEqualTo(new CarPosition(1));
    }

}
