package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingCountTest {

    @Test
    void 레이싱_시도_횟수_정상_생성() {
        assertThat(new RacingCount(4)).isEqualTo(new RacingCount(4));
    }

    @Test
    void 레이싱_횟수_1미만일_경우_예외발생() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new RacingCount(0);
        }).withMessageMatching(RacingCount.VALID_MSG_RACING_COUNT);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new RacingCount(-1);
        }).withMessageMatching(RacingCount.VALID_MSG_RACING_COUNT);
    }
}
