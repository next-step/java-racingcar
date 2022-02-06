package racing.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    void 전진_테스트() {
        final Position position = new Position(3);
        assertThat(position.move()).isEqualTo(new Position(4));
    }
}