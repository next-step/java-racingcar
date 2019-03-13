package racing;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingGameTest {
    private RacingGame racingGame;

    @Before
    public void racingGameTest() {
        this.racingGame = new RacingGame("shin, yeon, jong");
    }

    @Test
    public void createCarTest() {
        assertThat(this.racingGame.getRacingCars().size()).isEqualTo(3);
    }

    @Test
    public void getWinnerTest() {
        racingGame.getWinner(3).forEach(racingCar -> racingCar.toString());
    }
}