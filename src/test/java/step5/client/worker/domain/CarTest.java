package step5.client.worker.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import step5.client.worker.domain.strategy.MovableStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @DisplayName("isMovable")
    @Nested
    class IsMove {
        @DisplayName("앞으로 전진 가능")
        @Test
        void return_true() {
            // given
            final MovableStrategy mustMoveStrategy = () -> true;
            final Car car = Car.of("1", mustMoveStrategy);

            // when
            final boolean result = car.isMove();

            // then
            assertThat(result).isTrue();
        }

        @DisplayName("앞으로 전진 불가능")
        @Test
        void return_false() {
            // given
            final MovableStrategy mustNotMoveStrategy = () -> false;
            final Car car = Car.of("1", mustNotMoveStrategy);

            // when
            final boolean result = car.isMove();

            // then
            assertThat(result).isFalse();
        }
    }
}