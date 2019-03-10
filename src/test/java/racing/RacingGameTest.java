package racing;

import org.junit.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingGameTest {
    @Test
    public void 겟터셋터확인()
    {
        RacingGame rg = new RacingGame();
        rg.setTime(3);
        rg.setCarPositions(10);

        assertThat(rg.getTime()).isEqualTo(3);
        assertThat(rg.getCarPositions().length).isEqualTo(10);

        //assertThat(rg.getTime()).isEqual(3);
    }

    @Test
    public void 이동확인()
    {
        RacingGame rg = new RacingGame();
        rg.setTime(3);
        rg.setCarPositions(10);

        Random random = new Random();
        int[] testCarPosition = rg.getCarPositions();
        for (int i = 0; i < testCarPosition.length; i++) {
            if (random.nextInt(10) >= 4) {
                testCarPosition[i] += 1;
            }
        }
    }
}