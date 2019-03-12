package racing.board;

import org.junit.*;
import racing.model.RacingCar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


public class GameResultTest {


    @Test
    public void test_우승_1대() {
        String winnerName = "pobi";
        GameResult gameResult = new GameResult(Arrays.asList(winnerName));

        assertThat(gameResult.getWinners())
                .isEqualTo(winnerName);
    }

    @Test
    public void test_우승_2대() {
        String winnerName = "pobi, crong";
        List<String> winnerNames = Arrays.asList(winnerName.split(", "));
        GameResult gameResult = new GameResult(winnerNames);

        assertThat(gameResult.getWinners())
                .isEqualTo(winnerName);
    }
}