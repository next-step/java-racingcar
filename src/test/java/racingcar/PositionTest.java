package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    void 생성() {
        assertThat(new Position()).isEqualTo(new Position(0));
    }

    @Test
    void move() {
        Position position = new Position();
        assertThat(position.move()).isEqualTo(new Position(1));
    }

}
