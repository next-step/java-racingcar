package carracing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("자동차 전진을 위한 정책을 위한 테스트")
class RandomIntMovementPolicyTest {
    private RandomGenerator randomGenerator;
    private MovementPolicy movementPolicy;

    @BeforeEach
    void setUp() {
        randomGenerator = mock(RandomGenerator.class);
        movementPolicy = new RandomIntMovementPolicy(randomGenerator);
    }

    @DisplayName("정책에서 자동차 전진이 가능한 경우 확인")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void checkMovableCasesInPolicyTest(int movableNumber) {
        // When
        when(randomGenerator.generateZeroToNineInt())
                .thenReturn(movableNumber);

        // Then
        assertThat(movementPolicy.isMovable()).isTrue();
    }

    @DisplayName("정책에서 자동차 전진이 불가능한 경우 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void checkUnmovableCasesInPolicyTest(int unmovableNumber) {
        // When
        when(randomGenerator.generateZeroToNineInt())
                .thenReturn(unmovableNumber);

        // Then
        assertThat(movementPolicy.isMovable()).isFalse();
    }
}
