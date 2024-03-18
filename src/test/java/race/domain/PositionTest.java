package race.domain;

import org.junit.jupiter.api.Test;
import race.fixture.CarFixtures;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {
    @Test
    void position_생성() {
        Position position = new Position(5);
        assertThat(position).isEqualTo(new Position(5));
    }

    @Test
    void position_음수() {
        assertThatThrownBy(
                () -> new Position(-1)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동() {
        Position position = new Position(0);
        assertThat(position.move()).isEqualTo(new Position(1));
    }

    @Test
    void 위치_받아오기() {
        assertThat(new Position(CarFixtures.POBI.getPosition())).isEqualTo(new Position(0));
    }

    @Test
    void 같은_위치() {
        int position = 0;
        assertThat(new Position(CarFixtures.POBI.getPosition()).isSamePosition(position)).isTrue();
    }

    @Test
    void 최댓값() {
        assertThat(Math.max(1, new Position(3).getPosition())).isEqualTo(3);
    }
}
