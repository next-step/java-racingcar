package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class RacingGameEngineTest {
    @Test
    @DisplayName("게임이 play되면 game의 update가 적어도 한 번 호출되어야 함.")
    public void playTest() {
        MockedStatic<RacingGameInput> racingGameInputMockedStatic = Mockito.mockStatic(RacingGameInput.class);
        given(RacingGameInput.askTheNumberOfCar()).willReturn(3);
        given(RacingGameInput.askTheNumberOfCycle()).willReturn(1);

        RacingGame racingGame = Mockito.mock(RacingGame.class);
        given(racingGame.update()).willReturn(true);

        RacingGameEngine gameEngine = RacingGameEngine.createWithCustomRacingGame(racingGame);

        gameEngine.play();

        verify(racingGame).update();

        racingGameInputMockedStatic.close();
    }
}
