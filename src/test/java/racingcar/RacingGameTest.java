package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RacingGameTest {
    private InputView inputView = mock(InputView.class);
    private ResultView resultView = new ResultView();

    @Test
    void testPlay_given_3_cars_5_rounds() {
        // Given
        RacingGame racingGame = new RacingGame(inputView, resultView);
        when(inputView.input()).thenReturn(new InputView.InputResult(3, 5));

        // When
        racingGame.play();

        // Then
        assertThat(racingGame.getNumberOfCars()).isEqualTo(3);
        assertThat(racingGame.getCurrentRound()).isEqualTo(5);
    }
}