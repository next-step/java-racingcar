package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @DisplayName("랜덤넘버추출 체크_숫자가 0이상")
    @Test
    void 게임횟수_숫자확인_1이상() {
        assertThat(Car.randomNumberExtraction()).isGreaterThanOrEqualTo(0);
    }

    @DisplayName("랜덤넘버추출 체크_숫자가 9이하인지 확인")
    @Test
    void 게임횟수_숫자확인_9이하() {
        assertThat(Car.randomNumberExtraction()).isLessThanOrEqualTo(9);
    }
}

