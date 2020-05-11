package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RandomMovementTest {
    private static final int RANDOM_VALUE = 10;

    private RandomMovement randomMovement;

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("Random값이 4 이상인 경우")
    void graterThanFour(int randomValue) {
        Random random = mock(Random.class);
        when(random.nextInt(RANDOM_VALUE)).thenReturn(randomValue);
        randomMovement = new RandomMovement(random);
        assertThat(randomMovement.run()).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("Random값이 4 미만인 경우")
    void lessThanFour(int randomValue) {
        Random random = mock(Random.class);
        when(random.nextInt(RANDOM_VALUE)).thenReturn(randomValue);
        randomMovement = new RandomMovement(random);
        assertThat(randomMovement.run()).isEqualTo(false);
    }
}