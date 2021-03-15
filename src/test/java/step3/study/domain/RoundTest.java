package step3.study.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class RoundTest {

    @Test
    @DisplayName("round는 0미만일 수 없다.")
    void isNotRoundlessThenZeroTest(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Round round = new Round("0");
                }).withMessage("시행 횟수는 0회 이상이어야 합니다.");
    }

}