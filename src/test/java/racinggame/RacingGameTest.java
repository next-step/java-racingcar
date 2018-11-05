package racinggame;

import org.junit.Before;
import org.junit.Test;
import racinggame.rule.RandomNumberRacing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


public class RacingGameTest {

    String [] carName;

    @Before
    public void 레이싱_카셋팅(){
        carName = new String[]{"pobi","crong", "honux"};
    }

    @Test
    public void 레이싱_게임생성(){
        RacingGame racingGame = new RacingGame(carName, 5, new RandomNumberRacing());
        assertEquals(racingGame.getCar().size(), 3);
        assertThat(racingGame.nextRacingGame()).isTrue();
    }

    @Test
    public void 레이싱_게임_끝난경우(){
        RacingGame racingGame = new RacingGame(carName, 1, new RandomNumberRacing());
        racingGame.move();
        assertThat(racingGame.nextRacingGame()).isFalse();
    }

    @Test
    public void 레이싱_게임_진행가능한경우(){
        RacingGame racingGame = new RacingGame(carName, 2, new RandomNumberRacing());
        racingGame.move();
        assertThat(racingGame.nextRacingGame()).isTrue();
    }
}