package carracing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("자동차 경주의 자동차들을 위한 테스트")
class CarsTest {

    private static final int NUMBER_OF_CARS = 3;
    private static final int ONE = 1;
    private static final int BASE_POSITION_NUMBER = RandomIntMovementPolicy.BASE_POSITION_NUMBER;
    private static final int MAX_POSITION_NUMBER = RandomIntMovementPolicy.MAX_POSITION_NUMBER;
    private static final int MIN_POSITION_NUMBER = RandomIntMovementPolicy.MIN_POSITION_NUMBER;

    private RandomGenerator randomGenerator;
    private MovementPolicy movementPolicy;

    @BeforeEach
    void setUp() {
        randomGenerator = mock(RandomGenerator.class);
        movementPolicy = new RandomIntMovementPolicy(randomGenerator);
    }

    @DisplayName("자동차들의 생성여부 확인")
    @Test
    void createCarsTest() {
        // When
        Cars cars = new Cars(NUMBER_OF_CARS);

        // Then
        assertThat(cars.getCars().size()).isEqualTo(NUMBER_OF_CARS);
    }

    @DisplayName("자동차들의 이동이 가능한 경우, 이동했을 때 실제 이동하였는지 확인")
    @ParameterizedTest
    @MethodSource("provideMovableCases")
    void checkMovableCarsTest(int movableNumber, List<Integer> expected) {
        // Given
        Cars cars = new Cars(NUMBER_OF_CARS);

        // When
        when(randomGenerator.generateZeroToNineInt())
                .thenReturn(movableNumber);
        cars.moveCars(movementPolicy);
        List<Integer> positionOfCars = convertPositionOfCars(cars);

        // Then
        assertThat(positionOfCars).isEqualTo(expected);
    }

    @DisplayName("자동차들의 이동이 불가능 경우, 이동했을 때 실제 이동하였는지 확인")
    @ParameterizedTest
    @MethodSource("provideUnmovableCases")
    void checkUnmovableCarsTest(int unmovableNumber) {
        // Given
        Cars cars = new Cars(NUMBER_OF_CARS);
        List<Integer> expected = convertPositionOfCars(cars);

        // When
        when(randomGenerator.generateZeroToNineInt())
                .thenReturn(unmovableNumber);
        cars.moveCars(movementPolicy);
        List<Integer> positionOfCars = convertPositionOfCars(cars);

        // Then
        assertThat(positionOfCars).isEqualTo(expected);
    }

    private List<Integer> convertPositionOfCars(Cars cars) {
        return cars.getCars()
                .stream()
                .map(Car::getPosition)
                .map(CarPosition::getNumber)
                .collect(Collectors.toList());
    }

    private static Stream<Arguments> provideMovableCases() {
        List<Arguments> arguments = new ArrayList<>();
        for (int i = BASE_POSITION_NUMBER; i <= MAX_POSITION_NUMBER; i++) {
            arguments.add(Arguments.of(i, provideDuplicatedOnes()));
        }
        return arguments.stream();
    }

    private static List<Integer> provideDuplicatedOnes() {
        return provideDuplicatedValues(ONE);
    }

    private static List<Integer> provideDuplicatedValues(int duplicatedValue) {
        List<Integer> results = new ArrayList<>(NUMBER_OF_CARS);
        for (int i = 0; i < NUMBER_OF_CARS; i++) {
            results.add(duplicatedValue);
        }
        return results;
    }

    private static Stream<Arguments> provideUnmovableCases() {
        List<Arguments> arguments = new ArrayList<>();
        for (int i = MIN_POSITION_NUMBER; i < BASE_POSITION_NUMBER; i++) {
            arguments.add(Arguments.of(i));
        }
        return arguments.stream();
    }
}
