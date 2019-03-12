package racinggame;

import org.junit.Before;
import org.junit.Test;
import racinggame.Controller.RacingGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racinggame.View.PrintRacing.printWinner;
import static utils.ConstantCollection.FORWARD_NUMBER;
import static utils.ConstantCollection.RANGE_RANDOM;
import static utils.GenerateRandom.generatingRandomNumber;

public class RacingGameTest {
    RacingGame racing = new RacingGame();
    Map<String, Object> forTestMap = new HashMap<>();

    @Before
    public void setUp() {
        String userName = "Kim, Lee, Park";
        forTestMap.put("userName", userName);

        List<String> winners = new ArrayList<>();
        winners.add("Kim");
        winners.add("Park");
        forTestMap.put("winners", winners);
    }

    @Test
    public void randomCountTest() {
        int countCar = generatingRandomNumber(RANGE_RANDOM);
        int countGame = generatingRandomNumber(RANGE_RANDOM);

        racing.game((String)forTestMap.get("userName"), countCar, countGame);
    }

    @Test
    public void racingGameTest() {
        int countGame = generatingRandomNumber(RANGE_RANDOM);

        racing.game((String)forTestMap.get("userName"), 3, countGame);
    }

    @Test
    public void printWinnerTest() {
        printWinner((List<String>)forTestMap.get("winners"));
    }

    @Test
    public void ForwardStatusTest() {
        int random = generatingRandomNumber(RANGE_RANDOM);

        // 난수가 4이상인 경우 전진한다.
        if (random > FORWARD_NUMBER) {
            assertThat(true);
            return;
        }

        assertThat(false);
    }
}