package carracing.domain;

import carracing.util.RandomGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("자동차 경주의 자동차들을 위한 테스트")
class CarGroupTest {

    private static final int NUMBER_OF_CARS = 3;
    private static final int MOVABLE_POSITION_NUMBER_PER_MOVEMENT = 1;
    private static final int INITIATION_POSITION_NUMBER = 0;
    private static final int FIRST_MOVING_POSITION_NUMBER = INITIATION_POSITION_NUMBER + MOVABLE_POSITION_NUMBER_PER_MOVEMENT;
    private static final int BASE_POSITION_NUMBER = RandomIntMovementPolicy.BASE_POSITION_NUMBER;
    private static final int MAX_POSITION_NUMBER = RandomIntMovementPolicy.MAX_POSITION_NUMBER;
    private static final int MIN_POSITION_NUMBER = RandomIntMovementPolicy.MIN_POSITION_NUMBER;
    private static final int MOVABLE_POSITION_NUMBER = BASE_POSITION_NUMBER;
    private static final String TEST_CAR_NAMES = "pobi,crong,honux";
    private static final String DELIMITER = CarNameGroup.DELIMITER;

    private RandomGenerator randomGenerator;
    private MovementPolicy movementPolicy;

    @BeforeEach
    void setUp() {
        randomGenerator = mock(RandomGenerator.class);
        movementPolicy = new RandomIntMovementPolicy(randomGenerator);
    }

    @DisplayName("조건에 맞는 자동차 이름을 전달했을 때, 자동차들의 생성여부 확인")
    @ParameterizedTest
    @MethodSource("provideValidCarNames")
    void createCarsTest(CarNameGroup carNameGroup) {
        // When
        CarGroup carGroup = new CarGroup(carNameGroup);

        // Then
        assertThat(carGroup.getCars().size()).isEqualTo(NUMBER_OF_CARS);
    }

    @DisplayName("비어있는 자동차들의 이름을 전달했을 때, 자동차 생성 예외 발생 여부 확인")
    @ParameterizedTest
    @NullSource
    void checkExceptionWithInvalidCarNamesTest(CarNameGroup carNameGroup) {
        // When && Then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new CarGroup(carNameGroup)
        );
    }

    @DisplayName("우승한 자동차 검색이 가능한지 확인")
    @ParameterizedTest
    @MethodSource("provideValidCarNames")
    void retrieveWinningCarsTest(CarNameGroup carNameGroup) {
        // Given
        CarGroup carGroup = new CarGroup(carNameGroup);

        // When
        when(randomGenerator.generateZeroOrPositiveNumber(MAX_POSITION_NUMBER))
                .thenReturn(MOVABLE_POSITION_NUMBER);
        carGroup.moveCars(movementPolicy);
        String actual = convertWinningCarNames(carGroup);

        // Then
        assertThat(actual).isEqualTo(TEST_CAR_NAMES);
    }

    @DisplayName("자동차들의 이동이 가능한 경우, 이동했을 때 실제 이동하였는지 확인")
    @ParameterizedTest
    @MethodSource("provideMovableCases")
    void checkMovableCarsTest(int movableNumber, CarNameGroup carNameGroup) {
        // Given
        CarGroup carGroup = new CarGroup(carNameGroup);

        // When
        when(randomGenerator.generateZeroOrPositiveNumber(MAX_POSITION_NUMBER))
                .thenReturn(movableNumber);
        carGroup.moveCars(movementPolicy);
        List<Integer> positionOfCars = convertPositionOfCars(carGroup);

        // Then
        assertThat(positionOfCars)
                .hasSize(NUMBER_OF_CARS)
                .containsOnly(FIRST_MOVING_POSITION_NUMBER);
    }

    @DisplayName("자동차들의 이동이 불가능 경우, 이동했을 때 실제 이동하였는지 확인")
    @ParameterizedTest
    @MethodSource("provideUnmovableCases")
    void checkUnmovableCarsTest(int unmovableNumber, CarNameGroup carNameGroup) {
        // Given
        CarGroup carGroup = new CarGroup(carNameGroup);

        // When
        when(randomGenerator.generateZeroOrPositiveNumber(MAX_POSITION_NUMBER))
                .thenReturn(unmovableNumber);
        carGroup.moveCars(movementPolicy);
        List<Integer> positionOfCars = convertPositionOfCars(carGroup);

        // Then
        assertThat(positionOfCars)
                .hasSize(NUMBER_OF_CARS)
                .containsOnly(INITIATION_POSITION_NUMBER);
    }

    private String convertWinningCarNames(CarGroup carGroup) {
        return carGroup.retrieveWinningCars()
                .stream()
                .map(Car::getName)
                .map(CarName::getName)
                .collect(Collectors.joining(DELIMITER));
    }

    private List<Integer> convertPositionOfCars(CarGroup carGroup) {
        return carGroup.getCars()
                .stream()
                .map(Car::getPosition)
                .map(CarPosition::getNumber)
                .collect(Collectors.toList());
    }

    private static Stream<Arguments> provideValidCarNames() {
        List<Arguments> arguments = new ArrayList<>();
        arguments.add(Arguments.of(convertCarNamesForTest()));
        return arguments.stream();
    }

    private static CarNameGroup convertCarNamesForTest() {
        return new CarNameGroup(TEST_CAR_NAMES);
    }

    private static Stream<Arguments> provideMovableCases() {
        List<Arguments> arguments = new ArrayList<>();
        for (int i = BASE_POSITION_NUMBER; i <= MAX_POSITION_NUMBER; i++) {
            arguments.add(Arguments.of(i, convertCarNamesForTest()));
        }
        return arguments.stream();
    }

    private static Stream<Arguments> provideUnmovableCases() {
        List<Arguments> arguments = new ArrayList<>();
        for (int i = MIN_POSITION_NUMBER; i < BASE_POSITION_NUMBER; i++) {
            arguments.add(Arguments.of(i, convertCarNamesForTest()));
        }
        return arguments.stream();
    }
}
