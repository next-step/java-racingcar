package racing.application;

import org.junit.Test;
import racing.infrastructure.RandomGame;
import racing.view.RacingRequestView;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


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
    public void 한명이_게임_한번_실행() {
        //given
        RacingRequestView requestView = new RacingRequestView(1, 3);
        RacingGame racingGame = new RacingGame(requestView);
        RandomGame randomGame = mock(RandomGame.class);
        when(randomGame.win()).thenReturn(true);

        //when
        racingGame.start(randomGame);

        //then
        assertThat(racingGame.getView().getPositions().get(0)).isEqualTo(4);
    }
}