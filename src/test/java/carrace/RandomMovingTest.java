package carrace;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMovingTest {

    final int GO = 1;
    final int STOP = 0;

    @Test
    @DisplayName("DECISION_VALUE(4) 이상의 number를 입력받을 때에만 GO(1) 리턴")
    void move() {
        RandomMoving randomMoving = new RandomMoving();
        assertThat(randomMoving.move(true)).isEqualTo(GO);
        assertThat(randomMoving.move(false)).isEqualTo(STOP);
    }

}