package step4_racingCarWithWinner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {

    @Test
    @DisplayName("RacingGame 생성")
    public void createRacingGame(){
        String[] carNames = new String[]{"루피","조로"};
        int gameCount = 20;
        assertThat(new RacingGame(carNames, gameCount)).isInstanceOf(RacingGame.class);
    }

    @Test
    @DisplayName("CarNames 의 길이가 0 이하인 경우 게임종료된다.")
    public void carNamesLengthCheck(){
        String[] carNames = new String[]{};
        int gameCount = 20;
        assertThatThrownBy(()->new RacingGame(carNames, gameCount)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("gameCount 가 0 이하인 경우 게임종료된다.")
    public void gameCountCheck(int gameCount){
        String[] carNames = new String[]{"루피","조로"};
        assertThatThrownBy(()->new RacingGame(carNames, gameCount)).isInstanceOf(IllegalArgumentException.class);
    }
}
