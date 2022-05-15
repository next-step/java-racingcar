package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RandomNumberTest {
    @DisplayName("랜덤넘버추출 체크_숫자가 0이상")
    @Test
    void 게임횟수_숫자확인_1이상() {
        assertThat(RandomNumber.randomNumberExtraction()).isGreaterThanOrEqualTo(0);
    }

    @DisplayName("랜덤넘버추출 체크_숫자가 9이하인지 확인")
    @Test
    void 게임횟수_숫자확인_9이하() {
        assertThat(RandomNumber.randomNumberExtraction()).isLessThanOrEqualTo(9);
    }
}
