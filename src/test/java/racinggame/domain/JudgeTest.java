package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class JudgeTest {

    @Test
    void 우승자_판단() {
        // given
        final RacingCar racingCar1 = new RacingCar("car1", 2);
        final RacingCar racingCar2 = new RacingCar("car2", 1);
        final RacingCar racingCar3 = new RacingCar("car3", 0);

        final RacingCars racingCars = new RacingCars(
                Arrays.asList(racingCar1, racingCar2, racingCar3));

        // when
        final List<String> winners = Judge.getWinners(racingCars);

        // then
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.contains("car1")).isTrue();
    }

    @Test
    void 우승자_판단_우승이_두대_이상() {
        // given
        final RacingCar racingCar1 = new RacingCar("car1", 2);
        final RacingCar racingCar2 = new RacingCar("car2", 2);
        final RacingCar racingCar3 = new RacingCar("car3", 1);

        final RacingCars racingCars = new RacingCars(
                Arrays.asList(racingCar1, racingCar2, racingCar3));

        // when
        final List<String> winners = Judge.getWinners(racingCars);

        // then
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.containsAll(Arrays.asList("car1", "car2"))).isTrue();
    }
}
