package racingcar;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    RacingGame racingGame;

    @Before
    public void setUp() {
        racingGame = new RacingGame();
    }

    @Test
    public void 게임세팅() {
        racingGame.setGame(3, 5);
        assertThat(racingGame.getCarPositions().size()).isEqualTo(3);
        assertThat(racingGame.getTime()).isEqualTo(5);
    }

    @Test
    public void 새포지션_테스트() {
        int newPosition = racingGame.createNewPosition();
        assertThat(newPosition).isBetween(0,9);
    }

    @Test
    public void 달리기() {
        int result = racingGame.move(0);
        System.out.println("이건.. 어떻게 assert해야 할까요;; "  + result);
    }

    @Test
    public void 한라운드_결과() {
        racingGame.setGame(1,1);
        racingGame.playRound();
        System.out.println("랜덤값.. 테스트 코드... 어떻게... 확인하나요;;;  " + racingGame.getCarPositions());
    }

    @Test
    public void 게임결과() {
        racingGame.setGame(3,5);
        racingGame.play();
    }

    @After
    public void tearDown() {
        racingGame = null;
    }
}
