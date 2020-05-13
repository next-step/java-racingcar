package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.RandomMovement;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMovementTest {
    private RandomMovement randomMovement;

    void createRandomMovement(int randomValue) {
        randomMovement = new RandomMovement(new FakeRandom(randomValue));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("Random값이 4 이상인 경우")
    void graterThanFour(int randomValue) {
        this.createRandomMovement(randomValue);
        assertThat(randomMovement.isMove()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("Random값이 4 미만인 경우")
    void lessThanFour(int randomValue) {
        this.createRandomMovement(randomValue);
        assertThat(randomMovement.isMove()).isFalse();
    }
}