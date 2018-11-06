package game;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    RacingGame game;

    @Before
    public void setUp() {
        game = new RacingGame(2, 5);
    }

    @Test
    public void 랜덤값_0과9사이반환() {
        int randomValue = game.getRandomValue();
        assertThat(randomValue).isBetween(0, 9);
    }

    @Test
    public void 이동한다(){
        boolean value = game.isMove(5);
        assertThat(value).isEqualTo(true);
    }

    @Test
    public void 이동하지않는다(){
        boolean value = game.isMove(0);
        assertThat(value).isEqualTo(false);
    }
}