package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingGameTest {
    @DisplayName("N대의 자동차에 대해 M번 게임 진행")
    @Test
    void game() throws Exception {
        //given
        String names = "a,b,c";
        int repeatCount = 2;
        RacingGame racingGame = new RacingGame(names, repeatCount, new FixedPowerGenerator());

        //when
        racingGame.play();

        //then
        List<Car> carList = Arrays.asList(new Car(new CarName("a"), 2), new Car(new CarName("b"), 2), new Car(new CarName("c"), 2));
        Cars cars = new Cars(carList, new FixedPowerGenerator());
        RacingGame expected = new RacingGame(cars, repeatCount);

        assertEquals(expected, racingGame);
    }
}
