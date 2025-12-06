package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    void 값이_잘_저장된다() {
        Position position = new Position(3);
        assertThat(position).isEqualTo(new Position(3));
    }

    @Test
    void 이동하면_증가한_Position을_반환한다() {
        Position position = new Position(0);
        Position movedPosition = position.move();
        assertThat(movedPosition).isEqualTo(new Position(1));
    }

    @Test
    void 여러번_이동하면_누적된_Position을_반환한다() {
        Position position = new Position(0);
        Position movedPosition = position.move().move();
        assertThat(movedPosition).isEqualTo(new Position(2));
    }
}
