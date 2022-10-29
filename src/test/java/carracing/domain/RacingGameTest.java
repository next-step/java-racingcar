package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    @DisplayName("RacingGame Constructor Test")
    public void constructorTest() {
        List<String> nameList = Arrays.asList("name1","name2");
        RacingGame racingGame = new RacingGame(nameList, 5);
        assertThat(racingGame.getCarList().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Remain TryCount Test")
    public void remainTryCountTest() {
        List<String> nameList = Arrays.asList("name1","name2");
        RacingGame racingGame = new RacingGame(nameList, 2);
        assertThat(racingGame.remainTryCount()).isTrue();
        racingGame = new RacingGame(nameList, 0);
        assertThat(racingGame.remainTryCount()).isFalse();
    }

    @Test
    @DisplayName("Reduce TryCount Test")
    public void reduceTryCountTest() {
        List<String> nameList = Arrays.asList("name1","name2");
        RacingGame racingGame = new RacingGame(nameList, 2);
        racingGame.reduceTryCount();
        assertThat(racingGame)
                .usingRecursiveComparison()
                .comparingOnlyFields("carList", "tryCount")
                .isEqualTo(new RacingGame(nameList, 1));
    }
}