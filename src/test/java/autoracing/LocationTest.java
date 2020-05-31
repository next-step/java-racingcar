package autoracing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LocationTest {
    @Test
    public void testStartingLine() {
        Location startingLine = Location.STARTING_LINE;
        assertThat(startingLine.getDistance()).isEqualTo(0);
        assertThat(startingLine.getRound()).isEqualTo(0);
    }

    @Test
    public void testValueObject() {
        Location startingLine = Location.STARTING_LINE;
        assertThat(startingLine.move(13)).isNotEqualTo(startingLine);
    }

    @Test
    public void testMove() {
        Location startingLine = Location.STARTING_LINE;
        Location goingForward = startingLine.move(3);
        assertThat(goingForward.getRound()).isEqualTo(startingLine.getRound() + 1);
        assertThat(goingForward.getDistance()).isEqualTo(3);

        Location goingBackward = goingForward.move(-2);
        assertThat(goingBackward.getRound()).isEqualTo(goingForward.getRound() + 1);
        assertThat(goingBackward.getDistance()).isEqualTo(1);

        Location stoping = goingBackward.move(0);
        assertThat(stoping.getRound()).isEqualTo(goingBackward.getRound() + 1);
        assertThat(stoping.getDistance()).isEqualTo(1);
    }
}
