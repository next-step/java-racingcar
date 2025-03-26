package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.ResultView;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingGameTest {
    private RacingGame racingGame;
    private StubRandomNumberGenerator randomNumberGenerator;
    private String[] testCarNames;

    @BeforeEach
    public void setup() {
        testCarNames = new String[]{"A", "B", "C", "D", "E", "F"};
        StubInputView inputView = new StubInputView(testCarNames, 1);
        ResultView resultView = new ResultView();
        randomNumberGenerator = new StubRandomNumberGenerator();
        racingGame = new RacingGame(inputView, resultView, randomNumberGenerator);
    }

    @Test
    public void carsDontMoveWhenRandomNumberIsLT4() {
        randomNumberGenerator.setFixedValue(3);
        racingGame.initializeCars(testCarNames);
        List<Car> cars = racingGame.runRace(1);
        for (Car car : cars) {
            assertEquals(1, car.getPosition());
        }
    }

    @Test
    public void carsMoveWhenRandomNumberIsGTE4() {
        randomNumberGenerator.setFixedValue(4);
        racingGame.initializeCars(testCarNames);
        List<Car> cars = racingGame.runRace(1);
        for (Car car : cars) {
            assertEquals(2, car.getPosition());
        }
    }

    @Test
    @DisplayName("사용자가 입력한 이름의 숫자만큼 자동차 대수를 생성한다.")
    public void carsSizeEqualsNumberOfNames() {
        testCarNames = new String[]{"A", "B", "C", "D", "E", "F"};
        racingGame.initializeCars(testCarNames);

        assertThat(racingGame.getCars().size()).isEqualTo(testCarNames.length);
    }
}
