package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    void diceResult가_4이상인경우() {
        Position position = new Position();
        position.move(4);
        assertThat(position.currentPosition()).isEqualTo(1);
    }

    @Test
    void diceResult가_4미만인경우() {
        Position position = new Position();
        position.move(3);
        assertThat(position.currentPosition()).isEqualTo(0);
    }

}
