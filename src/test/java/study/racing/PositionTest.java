package study.racing;

import org.junit.jupiter.api.Test;
import study.racing.car.Position;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    void increase() {
        Position position = new Position(0);

        position.increase();

        assertThat(position.getValue()).isEqualTo(1);
    }

}
