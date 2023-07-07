package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PositionTest {
    @Test
    void nextTest() {
        //given
        Position position = new Position();

        //when, then
        assertThat(position.next()).isEqualTo(new Position(2));
    }

    @Test
    void compareToTest() {
        assertThat(new Position(2).compareTo(new Position(1))).isGreaterThan(0);
        assertThat(new Position(1).compareTo(new Position(1))).isEqualTo(0);
        assertThat(new Position(1).compareTo(new Position(2))).isLessThan(0);
    }
}