package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCars;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RandomMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {
    @Test
    @DisplayName("자동차 객체 여러개 생성 되는지 확인")
    public void checkRacingCarsObject() {
        String[] test =  new String[] {"pobi","next","step","fight","test"};
        RacingCars racingCars = new RacingCars(test);

        assertThat(racingCars.statusOfRacingCars()).hasSize(5);
    }

    @Test
    @DisplayName("runRacingRound를 통해 자동차 5대를 움직여 position =1 1이하 값인지 확인")
    public void runRacingRoundTest() {
        String[] test =  new String[] {"pobi","next","step","fight","test"};
        RacingCars racingCars = new RacingCars(test);
        MoveStrategy randomMoveStrategy = new RandomMoveStrategy();

        racingCars.runRacingRound(randomMoveStrategy);

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

    @Test
    @DisplayName("5대 자동차, 4번 움직임 시도(postion max값 == 4)인 racing 확인")
    public void checkRacingClass() {
        String[] test =  new String[] {"pobi","next","step","fight","test"};
        RacingCars racingCars = new RacingCars(test);
        MoveStrategy randomMoveStrategy = new RandomMoveStrategy();
        int numberOfTrials = 4;

        while (numberOfTrials > 0) {
            racingCars.runRacingRound(randomMoveStrategy);
            numberOfTrials--;
        }

        assertThat(racingCars.statusOfRacingCars()).hasSize(5);
        assertThat(racingCars.statusOfRacingCars().get(0).position())
                .isLessThanOrEqualTo(4);
    }
}