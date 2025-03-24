package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class PositionTest {

    @Test
    public void givenPosition_whenIncrease_thenPositionIncreased() {
        Position position = new Position(1);

        position.increase();

        assertThat(position.isSamePosition(2)).isTrue();
    }

    @Test
    public void givenNumber_whenMax_thenReturnMaxNumber() {
        Position position = new Position(1);

        int max = position.max(3);

        assertThat(max).isEqualTo(3);
    }
}