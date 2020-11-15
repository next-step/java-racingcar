package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PositionTest {

    @Test
    void create () {
        Position position = new Position(2);
        assertThat(position).isEqualTo(new Position(2));
    }

    @Test
    void valid () {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Position(-1)).withMessageMatching("position은 0보다 커야 합니다.");
    }

    @Test
    void move () {
        Position position = new Position(2);
        position = position.move();
        assertThat(position).isEqualTo(new Position(3));
    }


    @ParameterizedTest
    @DisplayName("최대 위치 구하기")
    @CsvSource(value = {"1:4:4", "3:2:3"}, delimiter = ':')
    void maxPositionTest (int number1, int number2, int maxNumber) {
        Position position1 = new Position(number1);
        Position position2 = new Position(number2);

        assertThat(position1.biggerPosition(position2)).isEqualTo(new Position(maxNumber));
    }
}
