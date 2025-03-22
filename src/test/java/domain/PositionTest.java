package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @DisplayName("Position 생성자 테스트")
    @Test
    void createValueTest() {
        int expected = 1;
        Position position = new Position(expected);
        Assertions.assertThat(position.value()).isEqualTo(expected);
    }

    @DisplayName("add 메소드 테스트")
    @Test
    void addTest() {
        int initialPosition = 0;
        int steps = 3;
        Position position = new Position(initialPosition);
        position.add(steps);
        Assertions.assertThat(position.value()).isEqualTo(initialPosition + steps);
    }

    @DisplayName("copy 메소드 테스트")
    @Test
    void copyTest() {
        int initialPosition = 0;
        Position position = new Position(initialPosition);
        Position copy = position.copy();

        Assertions.assertThat(copy.value()).isEqualTo(initialPosition);
        Assertions.assertThat(copy).isNotSameAs(position);
    }

    @DisplayName("isAheadOf 메소드 테스트")
    @Test
    void isAheadOfTest() {
        int small = 1;
        int big = 3;
        Position positionSmall = new Position(small);
        Position positionBig = new Position(big);

        Assertions.assertThat(positionBig.isAheadOf(positionSmall)).isTrue();
    }
}