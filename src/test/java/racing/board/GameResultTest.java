package racing.board;

import org.junit.*;
import racing.model.NamedRacingCar;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class GameResultTest {

    @Test
    public void test_결과_없음() {
        GameResult gameResult = new GameResult(Arrays.asList());

        assertThat(gameResult.getWinnerNames())
            .isEmpty();
    }

    @Test
    public void test_결과_있음() {
        GameResult gameResult = new GameResult(Arrays.asList(new NamedRacingCar("pobi")));

        assertThat(gameResult.getWinnerNames().size())
            .isGreaterThan(0);
    }
}