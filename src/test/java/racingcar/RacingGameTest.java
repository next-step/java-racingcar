package racingcar;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private RacingGame racingGame;

    @Test
    public void sortByValueTest() {
        racingGame = new RacingGame();
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            carList.add(new Car("a" + i, i));
        }
        racingGame.sortByValue(carList);
        int maxPosition = carList.get(0).getPosition();
        assertThat(maxPosition).isEqualTo(2);
    }

    @Test
    public void getWinnersTest() {
        Car car1 = new Car("test1", 0);
        Car car2 = new Car("test2", 1);
        List<Car> carList = new ArrayList<>();
        carList.add(car2);
        carList.add(car1);
        racingGame = new RacingGame();
        List<String> winners = racingGame.getWinners(carList);
        assertThat(winners.get(0)).isEqualTo("test2");

    }
}