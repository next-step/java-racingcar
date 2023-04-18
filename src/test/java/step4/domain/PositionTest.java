package step4.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PositionTest {

    @Test
    void Position_객체의_동등성을_비교한다() {
        final Position position1 = new Position();
        final Position position2 = new Position();

        assertThat(position1).isEqualTo(position2);
    }

    @Test
    void 랜덤값이_4이상이면_자동차는_전진한다() {
        final Position position = new Position();

        position.forward(4);

        assertThat(position.getDistance()).isEqualTo(1);
    }

    @Test
    void 랜덤값이_4미만이면_자동차는_멈춰있다() {
        final Position position = new Position();

        position.forward(3);

        assertThat(position.getDistance()).isEqualTo(0);
    }

    @Test
    void 우승자의_거리를_구한다() {
        Position winner = new Position();
        Position position1 = new Position();
        Position position2 = new Position();
        winner.forward(4);
        final List<Position> positions = List.of(winner, position1, position2);

        final Position actual = Position.winnerPosition(positions);

        assertAll(
                () -> assertThat(actual).isEqualTo(winner),
                () -> assertThat(actual.getDistance()).isEqualTo(1)
        );
    }

}