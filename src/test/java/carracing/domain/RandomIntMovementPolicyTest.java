package carracing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("자동차 전진을 위한 정책을 위한 테스트")
class RandomIntMovementPolicyTest {

    private static final int POLICY_BASE_NUMBER = RandomIntMovementPolicy.getPolicyBaseNumber();
    private static final int MAX_POSITION_NUMBER = 9;

    private RandomGenerator randomGenerator;
    private MovementPolicy movementPolicy;

    @BeforeEach
    void setUp() {
        randomGenerator = mock(RandomGenerator.class);
        movementPolicy = new RandomIntMovementPolicy(randomGenerator);
    }

    @DisplayName("정책에서 자동차 전진이 가능한 경우 확인")
    @ParameterizedTest
    @MethodSource("provideMovableCases")
    void checkMovableCasesInPolicyTest(int movableNumber) {
        // When
        when(randomGenerator.generateZeroToNineInt())
                .thenReturn(movableNumber);

        // Then
        assertThat(movementPolicy.isMovable()).isTrue();
    }

    private static Stream<Arguments> provideMovableCases() {
        List<Arguments> arguments = new ArrayList<>();
        for (int i = POLICY_BASE_NUMBER; i <= MAX_POSITION_NUMBER; i++) {
            arguments.add(Arguments.of(i));
        }
        return arguments.stream();
    }

    @DisplayName("정책에서 자동차 전진이 불가능한 경우 확인")
    @ParameterizedTest
    @MethodSource("provideUnmovableCases")
    void checkUnmovableCasesInPolicyTest(int unmovableNumber) {
        // When
        when(randomGenerator.generateZeroToNineInt())
                .thenReturn(unmovableNumber);

        // Then
        assertThat(movementPolicy.isMovable()).isFalse();
    }

    private static Stream<Arguments> provideUnmovableCases() {
        List<Arguments> arguments = new ArrayList<>();
        for (int i = 0; i < POLICY_BASE_NUMBER; i++) {
            arguments.add(Arguments.of(i));
        }
        return arguments.stream();
    }
}
