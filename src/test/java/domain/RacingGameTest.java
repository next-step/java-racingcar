package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class RacingGameTest {

    @Test
    void getWinnersTest() {
        ArrayList<Car> cars = new ArrayList<>();
        String carNames = "pobi,woni,jun";
        RacingGame racingGame = new RacingGame(carNames, 5);

        int[] carStatus = {5, 4, 5};
        int i = 0;
        for (Car car : racingGame.getCars()) {
            car.setStatus(carStatus[i]);
            cars.add(car);
            i++;
        }
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("pobi", "jun"));
        Assertions.assertThat(racingGame.getWinners()).isEqualTo(expected);
    }
}
