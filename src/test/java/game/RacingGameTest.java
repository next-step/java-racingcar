package game;

import game.ui.RacingGameInputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class RacingGameTest {

    @DisplayName("매회 게임마다 모든 자동차의 move 함수가 호출되어야 한다")
    @ParameterizedTest
    @MethodSource("source_verify_numberOfMove_shouldSucceed")
    public void verify_numberOfMove_shouldSucceed(int time, int numberOfCar, int expected) {
        MovePolicy movePolicy = mock(MovePolicy.class);
        RacingGameInputView racingGameInputView = mock(RacingGameInputView.class);
        RacingGame racingGame = new RacingGame(movePolicy, racingGameInputView);

        when(racingGameInputView.getTime()).thenReturn(time);
        when(racingGameInputView.getNumberOfCar()).thenReturn(numberOfCar);

        racingGame.play();

        verify(movePolicy, times(expected)).getPosition(anyInt());
    }

    private static Stream<Arguments> source_verify_numberOfMove_shouldSucceed() {
        return Stream.of(
                Arguments.of(1, 8, 8),
                Arguments.of(8, 1, 8),
                Arguments.of(2, 5, 10)
        );
    }
}
