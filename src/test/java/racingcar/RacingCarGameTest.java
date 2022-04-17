package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


public class RacingCarGameTest {
    @Test
    @DisplayName("랜덤숫자_조건_만족시_전진")
    void proceedCarWhenRandomNumConditionSatisfied() {
        int numOfRound = 3;
        RacingCar[] racingCars = {new RacingCar(), new RacingCar(), new RacingCar()};

        RandomNumCondition condition = spy(new RandomNumCondition());
        doReturn(true).when(condition).isSatisfied();

        RacingCarGame racingCarGame = new RacingCarGame(racingCars, numOfRound, condition);
        racingCarGame.start();

        Assertions.assertThat(racingCars[0].getLocation().getX()).isEqualTo(3);
        Assertions.assertThat(racingCars[1].getLocation().getX()).isEqualTo(3);
        Assertions.assertThat(racingCars[2].getLocation().getX()).isEqualTo(3);
    }

    @Test
    @DisplayName("랜덤숫자_조건_만족시키지_못했을경우_전진하지_않음")
    void notProceedCarWhenRandomNumConditionDisSatisfied() {
        int numOfRound = 3;
        RacingCar[] racingCars = {new RacingCar(), new RacingCar(), new RacingCar()};

        RandomNumCondition condition = spy(new RandomNumCondition());
        doReturn(false).when(condition).isSatisfied();

        RacingCarGame racingCarGame = new RacingCarGame(racingCars, numOfRound, condition);
        racingCarGame.start();

        Assertions.assertThat(racingCars[0].getLocation().getX()).isEqualTo(0);
        Assertions.assertThat(racingCars[1].getLocation().getX()).isEqualTo(0);
        Assertions.assertThat(racingCars[2].getLocation().getX()).isEqualTo(0);
    }
}
