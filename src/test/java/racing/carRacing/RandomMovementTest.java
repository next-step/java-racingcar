package racing.carRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMovementTest {

    @Test
    @DisplayName("random 범위 테스트")
    void randomBoundaryTest() {
        RandomMovement randomMovement = new RandomMovement();

        int movement = randomMovement.movement();

        assertThat(movement).isGreaterThanOrEqualTo(0);
        assertThat(movement).isLessThan(10);
    }

}