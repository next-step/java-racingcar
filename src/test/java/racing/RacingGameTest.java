package racing;

import org.junit.Test;

import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class RacingGameTest {

    @Test
    public void 랜덤학습테스트() {
        Random random = new Random();
        int result = 0;
        for(int i = 0; i < 100; i++){
            result = random.nextInt(10);
            assertThat(result).isGreaterThanOrEqualTo(0);
            assertThat(result).isLessThan(10);
        }
    }
    @Test
    public void 준비() {
        RacingGame racingGame = new RacingGame();

        int[] result = racingGame.readyCar(5);
        assertThat(result.length).isEqualTo(5);

        for (int i = 0; i < result.length; i++){
            assertThat(result[i]).isEqualTo(0);
        }

    }
    @Test
    public void 전진() {
        RacingGame racingGame = new RacingGame();
        assertThat(racingGame.readyCar(5).length).isEqualTo(5);
        int time = 3;
        int[] result = null;

        for(int i =0; i < time; i++){
            result = racingGame.move();
        }

        for(int i =0; i < result.length; i++){
            assertThat(result[i]).isGreaterThanOrEqualTo(0);
            assertThat(result[i]).isLessThanOrEqualTo(3);
        }

    }

    @Test
    public void 중계() {
        RacingGame racingGame = new RacingGame();
        int time = 3;
        assertThat(racingGame.readyCar(5).length).isEqualTo(5);

        racingGame.setTime(time);

        racingGame.watchRace();
    }

}