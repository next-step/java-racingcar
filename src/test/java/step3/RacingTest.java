package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.service.Racing;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created By mand2 on 2020-11-04.
 */
public class RacingTest {

    @Test
    @DisplayName("경주할 차가 0일 때")
    public void 경주_테스트_1() {
        assertThatThrownBy(() -> Racing.of("", 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("경기의 수가 0일 때")
    public void 경주_테스트_2() {
        assertThatThrownBy(() -> Racing.of("a,b,c", 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
