package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingMapTest {
    @DisplayName("우승자 선정")
    @Test
    void selectWinnerNames() {
        // given
        final List<RacingCar> racingCars = RacingCarFactory.createCars(Arrays.asList("CAR1", "CAR2", "CAR3"), () -> true);
        final RacingMap racingMap = new RacingMap(racingCars);
        final RacingCar car1 = racingCars.get(0);

        // when
        racingMap.move(car1, 1);

        // then
        final List<String> winners = racingMap.selectWinnerNames();
        assertThat(winners.get(0)).isEqualTo(car1.getName());
    }
}