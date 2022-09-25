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
        position.move();

        assertThat(position).isEqualTo(new Position(1));
    }

    @Test
    void getPosition() {
        assertThat(new Position(2).getPosition()).isEqualTo(2);
    }

}
