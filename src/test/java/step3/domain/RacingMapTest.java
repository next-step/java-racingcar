package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingMapTest {
    private final MovableStrategy MUST_MOVABLE = () -> true;
    private final MovableStrategy NEVER_MOVABLE = () -> false;
    @DisplayName("우승자 선정")
    @Nested
    class SelectWinnerNames {
        @DisplayName("한명")
        @Test
        void single() {
            // given
            final List<RacingCar> racingCars = Arrays.asList(
                    new RacingCar("CAR1", MUST_MOVABLE)
                    , new RacingCar("CAR2", NEVER_MOVABLE)
                    , new RacingCar("CAR3", NEVER_MOVABLE)
            );
            final RacingMap racingMap = RacingMap.of(racingCars);
            final RacingCar car1 = racingCars.get(0);

            // when
            racingMap.moveRacingCars(1);

            // then
            final List<String> winners = racingMap.selectWinnerNames();
            assertThat(winners.get(0)).isEqualTo(car1.getName());
        }

        @DisplayName("두명 이상")
        @Test
        void more_then_two() {
            // given
            final List<RacingCar> racingCars = Arrays.asList(
                    new RacingCar("CAR1", MUST_MOVABLE)
                    , new RacingCar("CAR2", MUST_MOVABLE)
                    , new RacingCar("CAR3", NEVER_MOVABLE)
            );
            final RacingMap racingMap = RacingMap.of(racingCars);
            
            final RacingCar car1 = racingCars.get(0);
            final RacingCar car2 = racingCars.get(1);

            // when
            racingMap.moveRacingCars(1);

            // then
            final List<String> winners = racingMap.selectWinnerNames();
            winners.sort(String::compareTo);
            assertThat(winners).isEqualTo(Arrays.asList(car1.getName(), car2.getName()));
        }
    }
}