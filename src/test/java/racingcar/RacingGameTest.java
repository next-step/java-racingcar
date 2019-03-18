package racingcar;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private RacingGame racingGame;

    @Test
    public void moveTest() {
        Car car = new Car("test1", 0);
        racingGame = new RacingGame();

        racingGame.move(car, 3);
        assertThat(car.getPosition()).isEqualTo(0);
        racingGame.move(car, 4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void addTest() {
        int result = RacingGame.add(1);
        assertThat(result).isEqualTo(2);
    }

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
    public void checkMoveTest() {
        boolean result = RacingGame.checkMove(3);
        assertThat(result).isFalse();
        result = RacingGame.checkMove(4);
        assertThat(result).isTrue();
    }
}