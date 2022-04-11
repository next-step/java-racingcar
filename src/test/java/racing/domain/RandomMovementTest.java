package racing.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMovementTest {
    @ParameterizedTest
    @CsvSource({"0,0", "1,0", "2,0", "3,0", "4,1", "5,1", "6,1", "7,1", "8,1", "9,1"})
    void 차가_전진_혹은_정지(int input, int expected) {
        RandomMovement randomMovement = new RandomMovement();
        assertThat(randomMovement.moveForwardOrStop(input)).isEqualTo(expected);
    }
}