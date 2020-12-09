package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingRoundTest {

    @Test
    @DisplayName("최종 우승자 구하는 테스트")
    void racing_one_winner_test() {
        // given
        List<RacingCar> racingCars = Arrays.asList(
                new RacingCar("pobi", 0),
                new RacingCar("crong", 1),
                new RacingCar("honux", 2),
                new RacingCar("YKJ", 3)
        );
        RacingRound racingRound = new RacingRound(racingCars);

        // when
        List<String> winners = racingRound.getWinners();

        // then
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners).containsExactly("YKJ");
    }

    @Test
    @DisplayName("우승자 여러명 구하는 테스트")
    void racing_two_winner_test() {
        // given
        List<RacingCar> racingCars = Arrays.asList(
                new RacingCar("pobi", 3),
                new RacingCar("crong", 1),
                new RacingCar("honux", 2),
                new RacingCar("YKJ", 3)
        );
        RacingRound racingRound = new RacingRound(racingCars);

        // when
        List<String> winners = racingRound.getWinners();

        // then
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners).containsExactly("pobi", "YKJ");
    }

}
