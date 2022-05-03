package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


public class RacingCarGameTest {
    @Test
    @DisplayName("전진_조건_만족시_한칸_전진")
    void proceedCarWhenConditionSatisfied() {
        int numOfRound = 3;
        RacingCar[] racingCars = {new RacingCar(new CarName("cool")), new RacingCar(new CarName("good")), new RacingCar(new CarName("amaze"))};

        RacingCarGame racingCarGame = new RacingCarGame(racingCars, numOfRound, new SatisfiedCondition());
        racingCarGame.start();

        Assertions.assertThat(racingCars[0].getLocation()).isEqualTo(3);
        Assertions.assertThat(racingCars[1].getLocation()).isEqualTo(3);
        Assertions.assertThat(racingCars[2].getLocation()).isEqualTo(3);
    }

    @Test
    @DisplayName("전진_조건_만족시키지_못했을경우_전진하지_않음")
    void notProceedCarWhenConditionDisSatisfied() {
        int numOfRound = 3;
        RacingCar[] racingCars = {new RacingCar(new CarName("cool")), new RacingCar(new CarName("good")), new RacingCar(new CarName("amaze"))};

        RacingCarGame racingCarGame = new RacingCarGame(racingCars, numOfRound, new DisSatisfiedCondition());
        racingCarGame.start();

        Assertions.assertThat(racingCars[0].getLocation()).isEqualTo(0);
        Assertions.assertThat(racingCars[1].getLocation()).isEqualTo(0);
        Assertions.assertThat(racingCars[2].getLocation()).isEqualTo(0);
    }

    @Test
    @DisplayName("가장 location 값이 큰 우승자 구하기")
    void findWinner() {
        RacingCar[] racingCars = {
                new RacingCar(new CarName("aaa"), 3),
                new RacingCar(new CarName("bbb"), 3),
                new RacingCar(new CarName("ccc"), 1)};
        RacingCarGame game = new RacingCarGame(racingCars, 3, new RandomNumCondition(new RandomGenerator(0, 9)));

        List<String> winners = game.findWinners();
        Assertions.assertThat(winners).containsExactly(racingCars[0].getName(), racingCars[1].getName());
    }

    static class SatisfiedCondition implements Condition {

        @Override
        public boolean isSatisfied() {
            return true;
        }
    }

    static class DisSatisfiedCondition implements Condition {

        @Override
        public boolean isSatisfied() {
            return false;
        }
    }
}
