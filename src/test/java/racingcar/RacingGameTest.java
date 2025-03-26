package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.ResultView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingGameTest {
    private RacingGame racingGame;
    private StubRandomNumberGenerator randomNumberGenerator;
    private String[] testCarNames;

    @BeforeEach
    public void setup() {
        testCarNames = new String[]{"A", "B", "C"};
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

    @Test
    @DisplayName("우승자 구하기")
    public void getWinnersTest() {
        racingGame.initializeCars(testCarNames);
        List<Car> cars = racingGame.getCars();

        cars.get(0).move(4);
        cars.get(0).move(4);

        List<Car> winners = racingGame.getWinners(cars);
        assertThat(winners).hasSize(1);
        assertThat(winners.get(0)).isEqualTo(cars.get(0));
    }
}
