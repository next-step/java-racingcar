package racing;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class GameRuleTest {
    @Test
    public void 게임룰인터페이스() {
        //GameRule gr = new CarGameRuleUseRandomNumber();
        GameRule gr = new CarGameRuleOnlyTrue();

        assertThat(gr.moveRacingGameRule()).isEqualTo(true);
        assertThat(gr.moveRacingGameRule()).isEqualTo(true);
        assertThat(gr.moveRacingGameRule()).isEqualTo(true);

        gr = new CarGameRuleOnlyFalse();

        assertThat(gr.moveRacingGameRule()).isEqualTo(false);
        assertThat(gr.moveRacingGameRule()).isEqualTo(false);
        assertThat(gr.moveRacingGameRule()).isEqualTo(false);

    }
}