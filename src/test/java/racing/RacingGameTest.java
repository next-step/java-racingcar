package racing;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class RacingGameTest {
    Random random = new Random();
    RacingGame racingGame;
    @Before
    public void setUp()  {
        racingGame = new RacingGame();
    }

    @Test
    public void 랜덤학습테스트() {

        int result = 0;
        for(int i = 0; i < 100; i++){
            result = random.nextInt(10);
            assertThat(result).isGreaterThanOrEqualTo(0);
            assertThat(result).isLessThan(10);
        }
    }
    @Test
    public void 준비_및_초기화확인() {
        int[] result = racingGame.readyCar(5);
        assertThat(result.length).isEqualTo(5);

        for (int i = 0; i < result.length; i++){
            assertThat(result[i]).isEqualTo(0);
        }
    }
    @Test
    public void 이동_및_이동거리확인() {
        int[] result = null;
        int tryCnt = 3;
        for(int i =0; i < tryCnt; i++){
            result = racingGame.move();
        }

        for(int i =0; i < result.length; i++){
            assertThat(result[i]).isGreaterThanOrEqualTo(0);
            assertThat(result[i]).isLessThanOrEqualTo(3);
        }
    }

    @Test
    public void 중계() {
        int time = 3;
        assertThat(racingGame.readyCar(5).length).isEqualTo(5);
        racingGame.setTime(time);
        new ResultView(racingGame).watchRace();
    }

    @Test
    public void readyCar() {
        assertThat(racingGame.readyCar(5).length).isEqualTo(5);
    }



}