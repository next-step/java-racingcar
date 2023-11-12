package carracing;

import carracing.domain.race.move.RandomMoveStopStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomMoveStopStrategyTest {
    @Test
    @DisplayName("4미만의 숫자는 0을 반환한다.")
    void under4IsZero() {
        // given
        RandomMoveStopStrategy randomMoveStopStrategy = new RandomMoveStopStrategy(() -> 3);

        // when
        int movePoint = randomMoveStopStrategy.getMovePoint();

        // then
        assertThat(movePoint).isEqualTo(0);
    }

    @Test
    @DisplayName("4이상의 숫자는 그 숫자를 반환한다.")
    void over4IsThis() {
        // given
        RandomMoveStopStrategy randomMoveStopStrategy = new RandomMoveStopStrategy(() -> 4);

        // when, then
        assertThat(randomMoveStopStrategy.getMovePoint()).isEqualTo(4);
    }
}
