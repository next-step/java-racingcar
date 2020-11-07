package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import step3.domain.strategy.MovableStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {
    @DisplayName("isMovable")
    @Nested
    class IsMovable {
        @DisplayName("앞으로 전진 가능")
        @Test
        void isMovable_return_true() {
            // given
            final MovableStrategy mustMoveStrategy = () -> true;
            final RacingCar racingCar = new RacingCar("1", mustMoveStrategy);

            // when
            final boolean result = racingCar.isMove();

            // then
            assertThat(result).isTrue();
        }

        @DisplayName("앞으로 전진 불가능")
        @Test
        void isMovable_return_false() {
            // given
            final MovableStrategy mustNotMoveStrategy = () -> false;
            final RacingCar racingCar = new RacingCar("1", mustNotMoveStrategy);

            // when
            final boolean result = racingCar.isMove();

            // then
            assertThat(result).isFalse();
        }
    }
}