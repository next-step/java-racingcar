package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingCar.domain.Position;

public class PositionTest {

    @Test
    void 이동거리만들기() {
        Position position = new Position(3);
        Assertions.assertThat(position.makePosition()).isEqualTo("---");

    }
}
