package game.racing;

import game.racing.domain.Car;
import game.racing.domain.GameResult;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    private GameResult gameResult;
    public static final int MAX_MOVE_COUNT = 3;
    private List<Car> testCars;

    @Before
    public void setup() {
        this.testCars = createTestCars(MAX_MOVE_COUNT);
        this.testCars.add(new Car(String.valueOf(MAX_MOVE_COUNT), MAX_MOVE_COUNT));
        this.testCars.add(new Car(String.valueOf(MAX_MOVE_COUNT), MAX_MOVE_COUNT));
        this.gameResult = new GameResult(testCars);
    }

    @Test
    public void 우승자이름찾기() {

        List<String> winnerNames = gameResult.getWinnerNames();

        assertThat(winnerNames.size()).isEqualTo(3);

        winnerNames.forEach(winnerName -> assertThat(winnerName).isEqualTo(String.valueOf(MAX_MOVE_COUNT)));
    }

    @Test
    public void 현재_게임상태_확인() {
        List<Car> cars = Arrays.asList(new Car("test1"), new Car("test2"));
        GameResult gameResult = new GameResult(cars);

        List<String> currentStates = gameResult.getCurrentStates();

        int count = 1;
        for (String currentState : currentStates) {
            assertThat(currentState).isEqualTo("test" + count + " : -");
            count++;
        }
    }

    private List<Car> createTestCars(int carCount) {
        List<Car> cars = new ArrayList<>(carCount);
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(String.valueOf(i + 1), i + 1));
        }

        return cars;
    }

}