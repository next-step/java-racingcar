package car_racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMoveStrategyTest {

    @Test
    @DisplayName("When the Random number is less than 4, car cannot move")
    void decideToMove_notAbleToMove() {
        // given
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy(0, 3);

        // when
        boolean ableToMove = randomMoveStrategy.decideToMove();
        // then
        assertThat(ableToMove).isFalse();
    }


    @Test
    @DisplayName("When the Random number is equal to or over 4, car can move")
    void decideToMove_ableToMove() {
        // given
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy(4, 9);

        // when
        boolean ableToMove = randomMoveStrategy.decideToMove();
        // then
        assertThat(ableToMove).isTrue();
    }

}