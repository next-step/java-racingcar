package game.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : yusik
 * @date : 2019/10/29
 */
public class CarMoverTest {

    @DisplayName("랜덤값과 threshold 값에 따른 움직임 결정")
    @Test
    void random() {
        assertThat(CarMover.movable(10, -1)).isTrue();
        assertThat(CarMover.movable(10, 11)).isFalse();
    }
}
