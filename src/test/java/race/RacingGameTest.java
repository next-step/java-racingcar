package race;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import race.domain.Car;
import race.domain.CarName;
import race.domain.FilterWinners;
import race.domain.MoveCars;
import race.view.outbound.OutputView;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RacingGameTest {
    @Mock
    private SetUpCars setUpCars;

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
    void whenNumberOfMovementIsNotPositive() {
        assertThatThrownBy(() -> new RacingGame(setUpCars, 0, outputView, moveCars, filterWinners))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("carsAndNumberOfMovement")
    void start(Collection<Car> carsSetUp, int numberOfMovement) {
        RacingGame racingGame = new RacingGame(setUpCars, numberOfMovement, outputView, moveCars, filterWinners);

        Collection<Car> winners = dummyCars(1);

        when(filterWinners.filter(argThat((cars) -> cars.size() == carsSetUp.size())))
                .thenReturn(winners);

        when(setUpCars.setUp())
                .thenReturn(carsSetUp);

        racingGame.start();

        verify(moveCars, times(numberOfMovement)).moveCars(
                argThat((argument) -> argument.size() == carsSetUp.size())
        );
        verify(outputView, times(numberOfMovement)).renderLocation(
                argThat((argument) -> argument.size() == carsSetUp.size())
        );
        verify(outputView, times(1)).renderWinners(winners);
    }

    private static Stream<Arguments> carsAndNumberOfMovement() {
        return Stream.of(
                Arguments.of(dummyCars(1), 2),
                Arguments.of(dummyCars(5), 6),
                Arguments.of(dummyCars(10), 10)
        );
    }

    private static Collection<Car> dummyCars(int numberOfCars) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(dummyCar());
        }
        return Collections.unmodifiableCollection(cars);
    }

    private static Car dummyCar() {
        return new Car(new CarName(UUID.randomUUID().toString().substring(0, 4)));
    }
}
