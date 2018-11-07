package racingGame;


import org.junit.Test;
import racingGame.domain.Car;
import racingGame.domain.GameResult;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    @Test
    public void 우승한_차가_한대일_경우_한대만_반환한다() {
        Car winner = new Car("winner", 3);
        Car other1 = new Car("other1", 1);
        Car other2 = new Car("other2",2);

        assertThat(GameResult.getWinners(Arrays.asList(winner, other1, other2)))
            .hasSize(1)
            .containsExactly(winner);
    }

    @Test
    public void 우승한_차가_여러대일_경우_여러대를_반환한다() {
        Car winner1 = new Car("winner1", 3);
        Car winner2 = new Car("winner2", 3);
        Car other = new Car("other", 2);

        assertThat(GameResult.getWinners(Arrays.asList(winner1, winner2, other)))
            .hasSize(2)
            .contains(winner1, winner2);
    }
}