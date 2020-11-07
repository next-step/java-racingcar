package step3.domain.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import step3.domain.RacingCar;

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
            final List<RacingCar> racingCars = Arrays.asList(
                    RacingCar.of("CAR1", MUST_MOVABLE, 1)
                    , RacingCar.of("CAR2", MUST_MOVABLE, 0)
                    , RacingCar.of("CAR3", MUST_MOVABLE, 0)
            );
            final RacingCar winner = racingCars.get(0);
            final SelectFarthestDistanceWinnerStrategy strategy = new SelectFarthestDistanceWinnerStrategy();

            // when
            final List<RacingCar> result = strategy.select(racingCars);

            // then
            assertThat(result.get(0)).isEqualTo(winner);
        }

        @DisplayName("두명 이상")
        @Test
        void more_then_two() {
            // given
            final List<RacingCar> racingCars = Arrays.asList(
                    RacingCar.of("CAR1", MUST_MOVABLE, 2)
                    ,RacingCar.of("CAR2", MUST_MOVABLE, 2)
                    ,RacingCar.of("CAR3", MUST_MOVABLE, 1)
                    ,RacingCar.of("CAR4", MUST_MOVABLE, 0)
            );
            final RacingCar winner1 = racingCars.get(0);
            final RacingCar winner2 = racingCars.get(1);
            final List<RacingCar> winners = Arrays.asList(winner1, winner2);
            final SelectFarthestDistanceWinnerStrategy strategy = new SelectFarthestDistanceWinnerStrategy();

            // when
            final List<RacingCar> result = strategy.select(racingCars);

            // then
            assertThat(result).isEqualTo(winners);
        }
    }
}