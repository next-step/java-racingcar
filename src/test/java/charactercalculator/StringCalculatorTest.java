package charactercalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @Test
    void null_input_test(){
        StringCalculator target = new StringCalculator();
        Assertions.assertThat(target.calculate()).isEqualTo(0);
    }

    @Test
    void zero_comma_test(){
        StringCalculator target = new StringCalculator("");
        Assertions.assertThat(target.calculate()).isEqualTo(0);
    }

    @Test
    void one_two_test(){
        StringCalculator target = new StringCalculator("1,2");
        Assertions.assertThat(target.calculate()).isEqualTo(3);
    }

    @Test
    void one_two_three_test(){
        StringCalculator target = new StringCalculator("1,2:3");
        Assertions.assertThat(target.calculate()).isEqualTo(6);
    }

    @Test
    void minus_test(){
        StringCalculator target = new StringCalculator("-1,2:3");
        Assertions.assertThatThrownBy(() -> target.calculate())
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("양수를 입력해야 합니다.");
    }

    @Test
    void custom_separator_test(){
        StringCalculator target = new StringCalculator("//;\n1;2;3");
        Assertions.assertThat(target.calculate()).isEqualTo(6);
    }
}