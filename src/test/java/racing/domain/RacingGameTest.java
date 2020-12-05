package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingGameTest {
    @DisplayName("N대의 자동차에 대해 M번 게임 진행")
    @Test
    void game() {
        //given
        int carCount = 3;
        int repeatCount = 2;
        RacingGame racingGame = new RacingGame(carCount, repeatCount, new FixedPowerGenerator());

        //when
        racingGame.start();

        //then
        Cars cars = new Cars(Arrays.asList(new Car(2), new Car(2), new Car(2)), new FixedPowerGenerator());
        RacingGame expected = new RacingGame(cars, repeatCount);

        assertEquals(expected, racingGame);
    }
}
