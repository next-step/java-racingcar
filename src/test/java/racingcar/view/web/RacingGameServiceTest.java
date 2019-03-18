package racingcar.view.web;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class RacingGameServiceTest {

    @Test
    public void getNames() {
        final String[] names = {"one", "two", "three"};

        Map<String, Object> expectedResult = new HashMap<>();
        expectedResult.put("cars", Arrays.asList(names));

        assertThat(RacingGameService.getNames(names)).isEqualTo(expectedResult);
    }

    @Test
    public void startGame() throws CloneNotSupportedException {
        final String[] names = {"one", "two", "three"};
        final int turn = 5;

        GameResult gameResult = RacingGameService.startGame(names, turn);

        assertThat(gameResult.getRaceResults().size()).isEqualTo(turn);
        assertThat(gameResult.getWinnerNames()).isNotEmpty();
        assertThat(gameResult.getWinnerNames()).containsAnyOf(names);
    }
}