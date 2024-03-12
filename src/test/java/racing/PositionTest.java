package racing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class PositionTest {

    @ParameterizedTest
    @CsvSource(value = {"1:2", "1:3", "2:3", "2:4", "3:5"}, delimiter = ':')
    void add(int startPosition, int addPosition) {
        Position position = new Position(startPosition);
        assertThat(position.add(addPosition)).isEqualTo(new Position(startPosition + addPosition));
    }

}