package racing;

import org.junit.Test;
import racing.application.RacingGame;
import racing.view.RacingRequestView;
import racing.view.RacingCarsView;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingGameTest {


    @Test
    public void 랜덤함수() {
        //given
        int expected = 3;
        Random random = new Random() {
            @Override
            public int nextInt(int bound) {
                return expected;
            }
        };

        //when
        int actual = random.nextInt(9);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void 게임한번실행() {
        //given
        RacingRequestView request = new RacingRequestView(3, 1);
        RacingGame game = new RacingGame(request);

        //when
        RacingCarsView actual = game.start();

        //then
        assertThat(game.getPosition(0)).isLessThanOrEqualTo(1);
    }

    @Test
    public void 게임여러번실행() {
        //given
        RacingRequestView request = new RacingRequestView(3, 3);
        RacingGame game = new RacingGame(request);

        //when
        game.start();

        //then
        assertThat(game.getPosition(0)).isBetween(0, 3);
    }
}