package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class PositionTest {

    @Test
    public void moveTest() {
        Position position = new Position(0);
        assertThat(position.move().getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 3, 3", "2, 1, 2"})
    public void maxTest(int initPosition, int input,int expectedPosition) {
        Position position = new Position(initPosition);
        assertThat(position.max(input)).isEqualTo(expectedPosition);
    }

    @ParameterizedTest
    @CsvSource(value = {"3, 3", "2, 2"})
    public void sameTest(int initPosition, int input) {
        Position position = new Position(initPosition);
        assertThat(position.isSame(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"3, 31", "2, 22"})
    public void sameFalseTest(int initPosition, int input) {
        Position position = new Position(initPosition);
        assertThat(position.isSame(input)).isFalse();
    }
}
