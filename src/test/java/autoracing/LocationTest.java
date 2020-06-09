package autoracing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LocationTest {
    @Test
    public void testStartingLine() {
        Location startingLine = Location.STARTING_LINE;
        assertThat(startingLine.getDistance()).isEqualTo(0);
    }

    @Test
    public void testValueObject() {
        Location startingLine = Location.STARTING_LINE;
        assertThat(startingLine.move(13)).isNotEqualTo(startingLine);
    }

    @ParameterizedTest
    @CsvSource({"3,3", "-2,-2", "0,0"})
    public void testMove(int movement, int expectingDistance) {
        Location startingLine = Location.STARTING_LINE;
        Location goingForward = startingLine.move(movement);
        assertThat(goingForward.getDistance()).isEqualTo(expectingDistance);
    }
}
