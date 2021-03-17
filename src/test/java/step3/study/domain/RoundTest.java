package step3.study.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class RoundTest {

    @Test
    @DisplayName("round는 0이상 이어야 한다.")
    void isNotRoundLessThenZeroTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Round round = new Round(-1);
                }).withMessage("시행 횟수는 0회 이상이어야 합니다.");
    }

}
