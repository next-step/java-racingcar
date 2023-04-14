package racing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;
import org.junit.jupiter.api.Test;

class RandomMoveTest {

    @Test
    void Boundary_3_Test() {
        assertThat(new RandomMove(new ReturnThree()).isMove())
            .isFalse();
    }

    @Test
    void Boundary_4_Test() {
        assertThat(new RandomMove(new ReturnFour()).isMove())
            .isTrue();
    }

    public static class ReturnThree extends Random {

        @Override
        public int nextInt(int bound) {
            return 3;
        }
    }

    public static class ReturnFour extends Random {

        @Override
        public int nextInt(int bound) {
            return 4;
        }
    }

}