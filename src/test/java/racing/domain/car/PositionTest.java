package racing.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    void positionEqualTest() {
        Position position = new Position(1);
        Position position1 = new Position(1);

        assertThat(position).isEqualTo(position1);
    }

}
