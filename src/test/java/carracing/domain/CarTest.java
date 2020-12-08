package carracing.domain;

import carracing.util.RandomGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("자동차를 위한 테스트")
class CarTest {

    private static final int INITIATION_POSITION_NUMBER = 0;
    private static final int FIRST_MOVING_POSITION_NUMBER = INITIATION_POSITION_NUMBER + 1;
    private static final int BASE_POSITION_NUMBER = RandomIntMovementPolicy.BASE_POSITION_NUMBER;
    private static final int MAX_POSITION_NUMBER = RandomIntMovementPolicy.MAX_POSITION_NUMBER;
    private static final int RANDOM_BOUND_NUMBER = RandomIntMovementPolicy.RANDOM_BOUND_NUMBER;

    private RandomGenerator randomGenerator;
    private MovementPolicy movementPolicy;

    @BeforeEach
    void setUp() {
        randomGenerator = mock(RandomGenerator.class);
        movementPolicy = new RandomIntMovementPolicy(randomGenerator);
    }

    @DisplayName("정상적인 자동차 생성 확인")
    @Test
    void createCarTest() {
        // When
        Car car = new Car();

        // Then
        assertAll(
                () -> assertThat(car).isNotNull(),
                () -> assertThat(car.getPosition().getNumber()).isEqualTo(INITIATION_POSITION_NUMBER)
        );
    }

    @DisplayName("자동차가 움직일 수 있는 경우, 자동자의 위치가 변경되는지 확인")
    @ParameterizedTest
    @MethodSource("provideMovableCases")
    void moveCarTest(int movableNumber) {
        // Given
        Car car = new Car();

        // When
        when(randomGenerator.generateZeroOrPositiveNumber(RANDOM_BOUND_NUMBER))
                .thenReturn(movableNumber);
        car.move(movementPolicy);

        // Then
        assertThat(car.getPosition().getNumber()).isEqualTo(FIRST_MOVING_POSITION_NUMBER);
    }

    private static Stream<Arguments> provideMovableCases() {
        List<Arguments> arguments = new ArrayList<>();
        for (int i = BASE_POSITION_NUMBER; i <= MAX_POSITION_NUMBER; i++) {
            arguments.add(Arguments.of(i));
        }
        return arguments.stream();
    }

    @DisplayName("자동차가 움직일 수 없는 경우, 자동자의 위치가 변경되는지 확인")
    @ParameterizedTest
    @MethodSource("provideUnmovableCases")
    void checkUnmovableCarTest(int unmovableNumber) {
        // Given
        Car car = new Car();

        // When
        when(randomGenerator.generateZeroOrPositiveNumber(RANDOM_BOUND_NUMBER))
                .thenReturn(unmovableNumber);
        car.move(movementPolicy);

        // Then
        assertThat(car.getPosition().getNumber()).isEqualTo(INITIATION_POSITION_NUMBER);
    }

    private static Stream<Arguments> provideUnmovableCases() {
        List<Arguments> arguments = new ArrayList<>();
        for (int i = 0; i < BASE_POSITION_NUMBER; i++) {
            arguments.add(Arguments.of(i));
        }
        return arguments.stream();
    }
}
