package race;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import race.outbound.OutputView;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RacingGameTest {
    @Mock
    private MoveCars moveCars;

    @Mock
    private OutputView outputView;

    @AfterEach
    void tearDown() {
        verifyNoMoreInteractions(moveCars, outputView);
    }

    @Test
    void whenNumberOfCarsIsNotPositive() {
        assertThatThrownBy(() -> new RacingGame(0, 10, outputView, moveCars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenNumberOfMovementIsNotPositive() {
        assertThatThrownBy(() -> new RacingGame(10, 0, outputView, moveCars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2", "5:6", "10:10"}, delimiter = ':')
    void start(int numberOfCars, int numberOfMovement) {
        RacingGame racingGame = new RacingGame(numberOfCars, numberOfMovement, outputView, moveCars);

        racingGame.start();

        verify(moveCars, times(numberOfMovement)).moveCars(
                argThat((argument) -> argument.size() == numberOfCars)
        );
        verify(outputView, times(numberOfMovement)).render(
                argThat((argument) -> argument.size() == numberOfCars)
        );
    }
}
