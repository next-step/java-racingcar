package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarCountTest {

    @Test
    void 자동차_대수_정상_생성() {
        assertThat(new CarCount(4)).isEqualTo(new CarCount(4));
    }

    @Test
    void 자동차_대수_1미만일_경우_예외발생 () {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new CarCount(0);
        }).withMessageMatching(CarCount.VALID_MSG_CAR_COUNT);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new CarCount(-1);
        }).withMessageMatching(CarCount.VALID_MSG_CAR_COUNT);
    }
}
