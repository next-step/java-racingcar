package race;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import race.outbound.OutputView;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RacingGameTest {
    @Mock
    private MoveCars moveCars;

    @Mock
    private OutputView outputView;

    @Mock
    private FilterWinners filterWinners;

    @AfterEach
    void tearDown() {
        verifyNoMoreInteractions(moveCars, outputView);
    }

    @Test
    void whenNumberOfCarsIsNotPositive() {
        assertThatThrownBy(() -> new RacingGame(Collections.EMPTY_LIST, 10, outputView, moveCars, filterWinners))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenNumberOfMovementIsNotPositive() {
        assertThatThrownBy(() -> new RacingGame(dummyCarNames(1), 0, outputView, moveCars, filterWinners))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("carNamesAndNumberOfMovement")
    void start(Collection<CarName> carNames, int numberOfMovement) {
        RacingGame racingGame = new RacingGame(carNames, numberOfMovement, outputView, moveCars, filterWinners);

        Collection<Car> winners = Collections.singleton(dummyCar());

        when(filterWinners.filter(argThat((cars) -> cars.size() == carNames.size())))
                .thenReturn(winners);

        racingGame.start();

        verify(moveCars, times(numberOfMovement)).moveCars(
                argThat((argument) -> argument.size() == carNames.size())
        );
        verify(outputView, times(numberOfMovement)).renderLocation(
                argThat((argument) -> argument.size() == carNames.size())
        );
        verify(outputView, times(1)).renderWinners(winners);
    }

    private Car dummyCar() {
        return new Car(new CarName(UUID.randomUUID().toString().substring(0, 4)));
    }

    private static Stream<Arguments> carNamesAndNumberOfMovement() {
        return Stream.of(
                Arguments.of(dummyCarNames(1), 2),
                Arguments.of(dummyCarNames(5), 6),
                Arguments.of(dummyCarNames(10), 10)
        );
    }

    private static Collection<CarName> dummyCarNames(int numberOfCars) {
        ArrayList<CarName> carNames = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            carNames.add(dummyCarName());
        }
        return Collections.unmodifiableCollection(carNames);
    }

    private static CarName dummyCarName() {
        return new CarName(UUID.randomUUID().toString().substring(0, 4));
    }
}
