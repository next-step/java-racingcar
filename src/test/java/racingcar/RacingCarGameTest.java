package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class RacingCarGameTest {
    @Test
    @DisplayName("전진_조건_만족시_한칸_전진")
    void proceedCarWhenConditionSatisfied() {
        int numOfRound = 3;
        RacingCar[] racingCars = {new RacingCar(), new RacingCar(), new RacingCar()};

        RacingCarGame racingCarGame = new RacingCarGame(racingCars, numOfRound, new SatisfiedCondition());
        racingCarGame.start();

        Assertions.assertThat(racingCars[0].getLocation().getX()).isEqualTo(3);
        Assertions.assertThat(racingCars[1].getLocation().getX()).isEqualTo(3);
        Assertions.assertThat(racingCars[2].getLocation().getX()).isEqualTo(3);
    }

    @Test
    @DisplayName("전진_조건_만족시키지_못했을경우_전진하지_않음")
    void notProceedCarWhenConditionDisSatisfied() {
        int numOfRound = 3;
        RacingCar[] racingCars = {new RacingCar(), new RacingCar(), new RacingCar()};

        RacingCarGame racingCarGame = new RacingCarGame(racingCars, numOfRound, new DisSatisfiedCondition());
        racingCarGame.start();

        Assertions.assertThat(racingCars[0].getLocation().getX()).isEqualTo(0);
        Assertions.assertThat(racingCars[1].getLocation().getX()).isEqualTo(0);
        Assertions.assertThat(racingCars[2].getLocation().getX()).isEqualTo(0);
    }

    private class SatisfiedCondition implements Condition {
        public boolean isSatisfied() {
            return true;
        }
    }

    private class DisSatisfiedCondition implements Condition {
        public boolean isSatisfied() {
            return false;
        }
    }
}
