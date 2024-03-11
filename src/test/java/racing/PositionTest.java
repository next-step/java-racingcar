package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PositionTest {

    @Test
    void addOne() {
        Position position1 = new Position();
        position1.addOne();

        Position position2 = new Position();
        position2.addOne();

        Position position3 = new Position();
        position3.addOne();
        position3.addOne();

        assertThat(position1).isEqualTo(position2);
        assertThat(position1).isNotEqualTo(position3);
    }

}