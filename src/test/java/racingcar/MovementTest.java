package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class MovementTest {
    @Test
    @DisplayName("random값이 4이상일 때 이동하는지 확인")
    void isMove_randomNumber_4이상() {
        Random mockRandom = new Random() {
            @Override
            public int nextInt() {
                return 4;
            }
        };
        Movement movement = new Movement(mockRandom);
        assertThat(movement.isMove()).isTrue();
    }

    @Test
    @DisplayName("random값이 4미만일 때 이동하지 않는지 확인")
    void isMove_randomNumber_4미만() {
        Random mockRandom = new Random() {
            @Override
            public int nextInt() {
                return 3;
            }
        };
        Movement movement = new Movement(mockRandom);
        assertThat(movement.isMove()).isTrue();
    }
}
