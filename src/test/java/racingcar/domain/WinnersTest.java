package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.moving.Position;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {
    @Test
    @DisplayName("우승자 이름목록을 정상적으로 가져오는지 확인한다")
    void checkWinnerNames() {
        // given
        RacingCars racingCars = RacingCars.of(Arrays.asList(
                RacingCar.of("blue", Position.of(10)),
                RacingCar.of("red", Position.of(5)),
                RacingCar.of("yellow", Position.of(7))
        ));
        // when
        Winners winners = Winners.of(racingCars.findWinners());
        // then
        assertThat(winners.getNames()).isEqualTo("blue");
    }

    @Test
    @DisplayName("우승자가 2명인경우 이름목록을 정상적으로 가져오는지 확인한다")
    void checkWinnerNames2() {
        // given
        RacingCars racingCars = RacingCars.of(Arrays.asList(
                RacingCar.of("blue", Position.of(10)),
                RacingCar.of("red", Position.of(5)),
                RacingCar.of("yellow", Position.of(10))
        ));
        // when
        Winners winners = Winners.of(racingCars.findWinners());
        // then
        assertThat(winners.getNames()).isEqualTo("blue,yellow");
    }
}
