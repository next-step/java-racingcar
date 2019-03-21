package racingcar.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private RacingGame racingGame;
    private List<Car> cars;

    @Before
    public void setUp() {
        cars = new ArrayList<>();
        cars.add(new Car("test", 0));
        cars.add(new Car("test1", 0));
        cars.add(new Car("test2", 0));
    }

    @Test
    public void racingTest() {
        RacingGame racingGame = new RacingGame(cars, 2);
        List<Car> cars = racingGame.racing();
        assertThat(cars.get(0).getPosition()).isBetween(0, 2);

    }

    @Test
    public void sortByValueTest() {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            carList.add(new Car("a" + i, i));
        }
        RacingGame.sortByValue(carList);
        int maxPosition = carList.get(0).getPosition();
        assertThat(maxPosition).isEqualTo(2);
    }

    @Test
    public void getWinnersTest() {
        List<Car> winners = RacingGame.getWinners(cars);
        assertThat(winners.get(0).getCarName()).isEqualTo("test2");

    }
}