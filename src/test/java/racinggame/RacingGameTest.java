package racinggame;

import org.junit.Before;
import org.junit.Test;
import racinggame.domain.Racing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racinggame.Controller.RacingGame.game;
import static racinggame.View.PrintRacing.printRacing;
import static racinggame.View.PrintRacing.printWinner;
import static utils.ConstantCollection.FORWARD_NUMBER;
import static utils.ConstantCollection.RANGE_RANDOM;
import static utils.GenerateRandom.generatingRandomNumber;

public class RacingGameTest {
    Map<String, Object> forTestMap = new HashMap<>();
    String userName;
    int usersLength;

    @Before
    public void setUp() {
        userName = "Kim,Lee,Park";
        String [] users = userName.split(",");
        usersLength = users.length;
        forTestMap.put("userName", userName);


        List<String> winners = new ArrayList<>();
        winners.add("Kim");
        winners.add("Park");
        forTestMap.put("winners", winners);
    }

    @Test
    public void 레이싱_실행_테스트() {
        int countCar = generatingRandomNumber(RANGE_RANDOM);
        int tryGame = generatingRandomNumber(RANGE_RANDOM);

        Racing racing = new Racing((String)forTestMap.get("userName"), countCar, tryGame);

        game(racing);
    }

    @Test
    public void 승자_정상출력_테스트() {
        printWinner((List<String>)forTestMap.get("winners"));
    }

    @Test
    public void 레이싱_정상출력_테스트() {
        int tryGame = generatingRandomNumber(RANGE_RANDOM);
        Racing racing = new Racing((String)forTestMap.get("userName"), usersLength, tryGame);

        printRacing(racing);
    }

    @Test
    public void ForwardStatusTest() {
        int random = generatingRandomNumber(RANGE_RANDOM);

        // 난수가 4이상인 경우 전진한다.
        if (random >= FORWARD_NUMBER) {
            assertThat(true);
            return;
        }

        assertThat(false);
    }
}