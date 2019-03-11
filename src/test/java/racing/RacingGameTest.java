package racing;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    @Test
    public void 게임초기값확인()
    {
        RacingGame rg = new RacingGame();

        // 무조건 이동되도록 룰적용
        GameRule gr = new GameRule(false);

        int time = 5;
        int carCount = 5;

        rg.initRacingGame(time,carCount);
        rg.runRacingGame(gr);

        for(int i = 0; i < time; i++)
        {
            assertThat(rg.getList().get(i).getMoveValues().get(i)).isEqualTo(i + 1);
        }
    }
}