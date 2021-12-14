package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.RacingGame;
import racingcar.domain.movingstrategy.AlwaysStopStrategy;
import racingcar.domain.movingstrategy.AlwaysGoStrategy;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingResultTest {

    @Test
    @DisplayName("getWinners 테스트: 최종 기록이 가장 좋은 RacingCars를 리턴한다.")
    void getWinners() {
        RacingCar racingCarA = new RacingCar(new RacingCarName("a"), new AlwaysGoStrategy());
        RacingCar racingCarB = new RacingCar(new RacingCarName("b"), new AlwaysGoStrategy());
        RacingCar racingCarC = new RacingCar(new RacingCarName("c"), new AlwaysStopStrategy());

        RacingGame racingGame = new RacingGame(3);
        racingGame.registerCar(racingCarA);
        racingGame.registerCar(racingCarB);
        racingGame.registerCar(racingCarC);

        RacingResult result = racingGame.start();

        RacingCars winners = result.getWinners();

        RacingCars expectecResult = new RacingCars(Arrays.asList(racingCarA, racingCarB));

        assertEquals(expectecResult, winners);
    }

}
