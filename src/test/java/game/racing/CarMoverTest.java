package game.racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : yusik
 * @date : 2019/10/29
 */
public class CarMoverTest {
    @Test
    void random() {
        assertThat(CarMover.movable(10, -1)).isTrue();
        assertThat(CarMover.movable(10, 11)).isFalse();
    }
}
