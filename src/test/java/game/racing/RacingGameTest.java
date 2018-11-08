package game.racing;

import game.racing.domain.Car;
import game.racing.domain.GameResult;
import game.racing.domain.RacingGame;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private RacingGame racingGame;

    @Before
    public void setup() {
        this.racingGame = new RacingGame(Collections.singletonList(new Car("test")));
    }


    @Test
    public void testMove() {
        GameResult gameResult = racingGame.move();

        assertThat(gameResult).isNotNull();
        assertThat(gameResult.getCurrentStates().size()).isEqualTo(1);
    }

}