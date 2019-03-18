package racingcar.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    public void 한라운드_진행() {
        RacingGame racingGame = new RacingGame(new String[]{"test1", "test2"}, 1);
        List<Car> result = racingGame.playRound(new RandomCreator() {
            @Override
            public int createNewPosition() {return 4;}

        });
        List<Car> expected = Arrays.asList(new Car("test1", 2), new Car("test2", 2));
        assertThat(result.contains(expected));
    }

}
