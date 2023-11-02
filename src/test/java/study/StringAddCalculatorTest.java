package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {


    @Test
    @DisplayName("문자열 분리, 빈문자인 경우 0 ")
    public void split_null_또는_빈문자() {
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        String[] result = stringAddCalculator.split(null);
        assertThat(result).containsExactly("0");

        result = stringAddCalculator.split("");
        assertThat(result).containsExactly("0");
    }

    @Test
    @DisplayName("문자열 분리, 숫자 하나만 있는 경우 하나만 리턴")
    public void split_숫자하나() throws Exception {
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        String[] result = stringAddCalculator.split("1");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("문자열 분리, 쉼표를 구분자로 숫자를 분리한다")
    public void split_쉼표구분자() throws Exception {
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        String[] result = stringAddCalculator.split("1,2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("문자열 분리, 쉼표 또는 콜론을 구분자로 숫자를 분리한다")
    public void split_쉼표_또는_콜론_구분자() throws Exception {
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        String[] result = stringAddCalculator.split("1,2:3");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("문자열 분리, 커스텀 구분자로 숫자를 분리한다")
    public void split_custom_구분자() throws Exception {
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        String[] result = stringAddCalculator.split("//;\n1;2;3");
        assertThat(result).containsExactly("1", "2", "3");
    }


    @Test
    @DisplayName("문자열 분리, 쉼표, 콜론, 커스텀 구분자로 숫자를 분리한다")
    public void split_custom_구분자_또는_쉼표_콜론_구분자() throws Exception {
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        String[] result = stringAddCalculator.split("//;\n1;2;3,4:5");
        assertThat(result).containsExactly("1", "2", "3", "4", "5");
    }


    @Test
    @DisplayName("양수 변환, 문자를 정수로 변환한다. 음수인 경우 Exception 발생")
    public void positivie_negative() throws Exception {
        assertThatThrownBy(() -> new PositiveNumber("-1"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("양수 변환, 문자를 정수로 변환한다. 숫자가 아닌 경우 Exception 발생")
    public void positiveNumber_nonNumber() throws Exception {
        assertThatThrownBy(() -> new PositiveNumber("abc"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("양수 변환, 문자를 정수로 변환한다.")
    public void positiveNumber_number() {
        PositiveNumber positiveNumber = new PositiveNumber("1");
        assertThat(positiveNumber.value()).isEqualTo(1);
    }

}
