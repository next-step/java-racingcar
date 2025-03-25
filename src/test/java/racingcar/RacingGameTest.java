package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.ResultView;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingGameTest {
    private RacingGame racingGame;
    private StubRandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    public void setup() {
        StubInputView inputView = new StubInputView(3, 1);
        ResultView resultView = new ResultView();
        randomNumberGenerator = new StubRandomNumberGenerator();
        racingGame = new RacingGame(inputView, resultView, randomNumberGenerator);
    }

    @Test
    public void carsDontMoveWhenRandomNumberIsLT4() {
        randomNumberGenerator.setFixedValue(3);
        racingGame.initializeCars(3);
        List<Car> cars = racingGame.runRace(1);
        for (Car car : cars) {
            assertEquals(1, car.getPosition());
        }
    }

    @Test
    public void carsMoveWhenRandomNumberIsGTE4() {
        randomNumberGenerator.setFixedValue(4);
        racingGame.initializeCars(3);
        List<Car> cars = racingGame.runRace(1);
        for (Car car : cars) {
            assertEquals(2, car.getPosition());
        }
    }
}
