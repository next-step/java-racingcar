package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCars;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.NormalMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {
    @Test
    @DisplayName("자동차 객체 여러개 생성 되는지 확인")
    public void checkRacingCarsObject() {
        RacingCars racingCars = new RacingCars(5);

        assertThat(racingCars.statusOfRacingCars()).hasSize(5);
    }

    @Test
    @DisplayName("runRacingRound를 통해 자동차 5대를 움직여 position =1 1이하 값인지 확인")
    public void runRacingRoundTest() {
        RacingCars racingCars = new RacingCars(5);
        MoveStrategy normalMoveStrategy = new NormalMoveStrategy();

        racingCars.runRacingRound(normalMoveStrategy);

        assertThat(racingCars.statusOfRacingCars().get(0).position())
                .isLessThanOrEqualTo(1);
        assertThat(racingCars.statusOfRacingCars().get(1).position())
                .isLessThanOrEqualTo(1);
        assertThat(racingCars.statusOfRacingCars().get(2).position())
                .isLessThanOrEqualTo(1);
        assertThat(racingCars.statusOfRacingCars().get(3).position())
                .isLessThanOrEqualTo(1);
        assertThat(racingCars.statusOfRacingCars().get(4).position())
                .isLessThanOrEqualTo(1);
    }
}