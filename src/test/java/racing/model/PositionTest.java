package racing.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {
    @Test
    void create() {
        assertThat(new Position().getPosition()).isEqualTo(0);
    }

    @Test
    void move() {
        Position position1 = new Position().moveOnSatisfiedCondition(4);
        assertThat(position1.getPosition()).isEqualTo(0);

        Position position2 = new Position().moveOnSatisfiedCondition(5);
        assertThat(position2.getPosition()).isEqualTo(1);
    }
}