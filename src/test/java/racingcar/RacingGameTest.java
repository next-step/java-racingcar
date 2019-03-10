package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Random;
import org.junit.Test;

public class RacingGameTest {

    private int numberOfCars = 3;
    private int numberOfTimes = 5;

    @Test
    public void test_load() throws Exception {
        List<RacingGameBoard> racingGameBoards = RacingGame.load(numberOfCars, numberOfTimes);

        assertThat(racingGameBoards.size()).isEqualTo(numberOfTimes);
    }

    @Test
    public void test_play() throws Exception {
        List<RacingGameBoard> racingGameBoards = RacingGame
            .play(RacingGame.load(numberOfCars, numberOfTimes), numberOfCars, numberOfTimes);

        assertThat(racingGameBoards.get(0).getCars().size()).isEqualTo(numberOfCars);

        Random random = new Random();
        int randomNum = random.nextInt(numberOfTimes - 1);

        assertThat(racingGameBoards.get(randomNum).getCars().get(0).getPosition())
            .isLessThanOrEqualTo(racingGameBoards.get(randomNum + 1).getCars().get(0).getPosition());
    }
}