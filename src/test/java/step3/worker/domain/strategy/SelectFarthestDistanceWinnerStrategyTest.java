package step3.worker.domain.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import step3.worker.domain.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SelectFarthestDistanceWinnerStrategyTest {
    private final MovableStrategy MUST_MOVABLE = () -> true;

    @DisplayName("우승자 선정")
    @Nested
    class SelectWinner {
        @DisplayName("한명")
        @Test
        void single() {
            // given
            final List<Car> cars = Arrays.asList(
                    Car.of("CAR1", MUST_MOVABLE, 1)
                    , Car.of("CAR2", MUST_MOVABLE, 0)
                    , Car.of("CAR3", MUST_MOVABLE, 0)
            );
            final Car winner = cars.get(0);
            final SelectFarthestDistanceWinnerStrategy strategy = new SelectFarthestDistanceWinnerStrategy();

            // when
            final List<Car> result = strategy.select(cars);

            // then
            assertThat(result.get(0)).isEqualTo(winner);
        }

        @DisplayName("두명 이상")
        @Test
        void more_then_two() {
            // given
            final List<Car> cars = Arrays.asList(
                    Car.of("CAR1", MUST_MOVABLE, 2)
                    , Car.of("CAR2", MUST_MOVABLE, 2)
                    , Car.of("CAR3", MUST_MOVABLE, 1)
                    , Car.of("CAR4", MUST_MOVABLE, 0)
            );
            final Car winner1 = cars.get(0);
            final Car winner2 = cars.get(1);
            final List<Car> winners = Arrays.asList(winner1, winner2);
            final SelectFarthestDistanceWinnerStrategy strategy = new SelectFarthestDistanceWinnerStrategy();

            // when
            final List<Car> result = strategy.select(cars);

            // then
            assertThat(result).isEqualTo(winners);
        }
    }
}