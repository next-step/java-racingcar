package step4.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PositionTest {

    @Test
    void Position_객체의_동등성을_비교한다() {
        final Position position1 = Position.create();
        final Position position2 = Position.create();

        assertThat(position1).isEqualTo(position2);
    }

    @Test
    void Position_객체의_초기값은_0이다() {
        final Position position = Position.create();

        assertThat(position.getDistance()).isEqualTo(0);
    }

    @Test
    void 자동차가_전진하면_거리가_1_증가한다() {
        final Position position = Position.create();

        position.forward();

        assertThat(position.getDistance()).isEqualTo(1);
    }

    @Test
    void 우승자의_거리를_구한다() {
        Position winner = Position.create();
        Position position1 = Position.create();
        Position position2 = Position.create();
        winner.forward();
        final List<Position> positions = List.of(winner, position1, position2);

        final Position actual = Position.winnerPosition(positions);

        assertAll(
                () -> assertThat(actual).isEqualTo(winner),
                () -> assertThat(actual.getDistance()).isEqualTo(1)
        );
    }

}