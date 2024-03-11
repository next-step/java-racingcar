package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class CarsCountTest {

    @Test
    void 생성자_음수_유효성_검증() {
        int invalidInteger = -1;

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CarsCount(invalidInteger))
                .withMessageMatching("자동차 대수가 음수 입력입니다: -\\d");
    }
}
