package racingcarwinnerrefactor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcarwinnerrefactor.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    Position position;

    @BeforeEach
    void setUp() {
        position = new Position();
    }

    @Test
    void 자동차위치_한칸전진() {
        position.move(() -> true);
        assertThat(position.equals(new Position(1))).isTrue();
    }

    @Test
    void 자동차위치_정지() {
        position.move(() -> false);
        assertThat(position.equals(new Position())).isTrue();
    }
}
