package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    void moveOneStep_메서드는_위치를_한칸_이동시킵니다() {
        Position position = new Position();

        Position expected = new Position(1);
        Position result = position.moveOneStep();

        assertThat(result).isEqualTo(expected);
    }

}
