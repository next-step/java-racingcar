
package racingcar.domain;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private final String[] testNames = {"a", "b", "c"};
    private final int testPosition = 5;
    private final String resultSamePositionString = ", b";
    private final String resultWinnersString = "a, b";
    RacingGame racingGame;
    private final Car firstWinner = new Car(testPosition, "a");
    private Car secondWinner;
    private final List<Car> cars = new ArrayList<Car>();

    @Before
    public void setUp() {
        racingGame = new RacingGame(testNames, 4);
        secondWinner = new Car(5, "b");
        cars.add(firstWinner);
        cars.add(secondWinner);
    }

    // nameCompare 함수는 private로 두고 싶은데,
    // private 함수 테스트 방법이 없을까요?
    @Test
    public void 우승자가_여러명인지_체크() {
        String result = racingGame.nameCompare(firstWinner.getPosition(), secondWinner);
        assertThat(result).isEqualTo(resultSamePositionString);
    }

    // 이 함수도 private로 하고 싶어요;;
    @Test
    public void 우승자명단확보() {
        String result = racingGame.collectWinners(cars);
        assertThat(result).isEqualTo(resultWinnersString);
    }

    @After
    public void tearDown() {
        racingGame = null;
        secondWinner = null;
    }
}
