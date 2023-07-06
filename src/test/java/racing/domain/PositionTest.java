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
}