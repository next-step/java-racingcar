package study.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.RacingGame;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame();
    }

    @Test
    void initiateCarObjectTest() {
        int[] cars = racingGame.carPositionsInitiate(3);
        assertThat(cars).contains(0);
        assertThat(cars).hasSize(3);
    }

    @Test
    void RandomCountTest() {
        assertThat(racingGame.getRandomNumber()).isBetween(0, 9);
    }

    @Test
    void moveCarTest() {
        racingGame.getTime(4);
        racingGame.carPositionsInitiate(5);
        System.out.println(Arrays.toString(racingGame.move()));
    }

    @Test
    void resultViewTest() {
        racingGame.getTime(4);
        racingGame.carPositionsInitiate(5);
        racingGame.execute();
        racingGame.print();

    }
}
