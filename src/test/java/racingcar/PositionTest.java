package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    private Position position;

    @BeforeEach
    void init() {
        position = new Position();
    }

    @Test
    @DisplayName("포지션은 처음 생성되면 무조건 0의 위치를 가진다.")
    void createPosition() {
        assertThat(position.getNumber()).isZero();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
    @DisplayName("포지션에 움직여야할 숫자를 넘겨주면 해당 수만큼 움직인다.")
    void movePosition(int moveCount, int expected) {
        position.move(moveCount);

        assertThat(position.getNumber()).isEqualTo(expected);
    }
}
