package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class RaceCountTest {

    @Test
    void 생성자_음수_유효성_검증() {
        int invalidInteger = -1;

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RaceCount(invalidInteger))
                .withMessageMatching("시도할 회수가 음수 입력입니다: -\\d");
    }
}
