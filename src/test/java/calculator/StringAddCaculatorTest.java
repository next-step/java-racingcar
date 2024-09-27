package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.StringAddCaculator.splitAndSum;
import static org.assertj.core.api.Assertions.assertThat;


class StringAddCaculatorTest {

    @DisplayName("입력 값이 0 또는 null인 경우 합은 0이다")
    @Test
    void emptyTextOrNull(){
        assertThat(splitAndSum("0")).isZero();
        assertThat(splitAndSum(null)).isZero();
    }
}