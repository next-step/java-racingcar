package carracing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class RacingUtilsTest {

    @Test
    @DisplayName("랜덤 최대 값 확인")
    void max() {
        assertThat(RacingUtils.MAX_RANDOM).isEqualTo(10);
    }

    @Test
    @DisplayName("자동차가 전진할 값 확인")
    void run() {
        assertThat(RacingUtils.MIN_FORWARD_NUMBER).isEqualTo(4);
    }

    @Test
    @DisplayName("자동차가 몇 초마다 움직일지에 대한 타이머 값 확인")
    void timer() {
        assertThat(RacingUtils.TIMER).isEqualTo(1000);
    }

    @Test
    @DisplayName("자동차 움직임 표시 확인")
    void dash() {
        assertThat(RacingUtils.DASH).isEqualTo("-");
    }

    @Test
    @DisplayName("백스페이스 확인")
    void backspace() {
        assertThat(RacingUtils.BACKSPACE).isEqualTo("\b");
    }

}
