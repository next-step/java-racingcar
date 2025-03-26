package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @DisplayName("incrementPosition() 호출시 1 증가된 Position이 반환된다.")
    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 2",
            "2, 3",
            "3, 4",
    })
    void incrementPosition(int initialPosition, int expectedPosition) {
        Position position = new Position(initialPosition);

        Position movedPosition = position.incrementPosition();

        assertThat(movedPosition.getPosition()).isEqualTo(expectedPosition);
    }
}
