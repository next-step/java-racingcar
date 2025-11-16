package racinggame.model.position;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    void 위치값을_증가시킬_수_있다() {
        Position position = new Position();
        position.plus();

        assertThat(
                position.equals(new Position(1))
        ).isTrue();
    }

    @Test
    void 주어진_위치값_보다_자동차_위치값이_더_작은걸_판별할_수_있다() {
        Position lowerPosition = new Position();
        lowerPosition.plus();

        Position higherPosition = new Position();
        higherPosition.plus();
        higherPosition.plus();

        assertThat(
                lowerPosition.hasDownPosition(higherPosition)
        ).isTrue();
    }
}