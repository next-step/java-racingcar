package step4_racintCarWithWinner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    @DisplayName("RacingGame 생성")
    public void createRacingGame(){
        String[] carNames = new String[]{"루피","조로"};
        int gameCount = 20;
        assertThat(new RacingGame(carNames, gameCount)).isInstanceOf(RacingGame.class);
    }

}
