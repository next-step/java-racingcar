package service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class StringAddCalculatorServiceTest {

    @Test
    void splitAndSum_null_string() {
        assertThat(StringAddCalculatorService.splitAndSum(null)).isZero();

    }

    @Test
    void splitAndSum_empty_string() {
        assertThat(StringAddCalculatorService.splitAndSum("")).isZero();
    }


    @Test
    void splitAndSum_one_integer_string() {
        assertThat(StringAddCalculatorService.splitAndSum("1")).isEqualTo(1);
    }

    @Test
    void splitAndSum_comma_delimiter() {
        assertThat(StringAddCalculatorService.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void splitAndSum_comma_colon_delimiter() {
        assertThat(StringAddCalculatorService.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void splitAndSum_custom_delimiter() {
        assertThat(StringAddCalculatorService.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void splitAndSum_negative_string() {
        assertThatThrownBy(() -> StringAddCalculatorService.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void splitAndSum_invalid_string() {
        assertThatThrownBy(() -> StringAddCalculatorService.splitAndSum("a,b,c"))
                .isInstanceOf(RuntimeException.class);
    }
}
