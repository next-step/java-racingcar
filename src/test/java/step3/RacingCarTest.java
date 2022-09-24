package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static step3.GameRule.*;

class RacingCarTest {

    @Test
    void random_0_9_사이() {
        int result = GameRule.randomNum();
        assertThat(result).isLessThan(10);
    }

    @Test
    void move_forward_차가_전진했을_경우() {
        assertThat(decideMove(4)).isEqualTo(1);
    }

    @Test
    void move_stop_차가_그대로일_경우() {
        assertThat(decideMove(3)).isEqualTo(0);
    }


}