package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMovementTest {

    @Test
    @DisplayName("자동차가 무작위로 움직인다.")
    void moveOrStay() {
        Movement movement = new RandomMovement();
        int lastLocation = 0;

        boolean isMoved = false;
        boolean isStayed = false;

        for (int i = 0; i < 100; i++) {

            int currentLocation = lastLocation + movement.move();

            isMoved |= lastLocation != currentLocation;
            isStayed |= lastLocation == currentLocation;

            lastLocation = currentLocation;
        }

        assertThat(isMoved && isStayed).isTrue();
    }

}
