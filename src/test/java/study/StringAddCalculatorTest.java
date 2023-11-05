package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("문자열 분리, null 이나 빈문자인 경우 return 0 ")
    public void split_null_또는_빈문자(String text) {
        Parser parser = new Parser(text);
        assertThat(parser.content()).isEqualTo("0");
    }

    @Test
    @DisplayName("문자열 분리, 숫자 하나만 있는 경우 하나만 리턴")
    public void split_숫자하나() {
        Parser parser = new Parser("1");
        assertThat(parser.content()).isEqualTo("1");
    }

    @Test
    @DisplayName("문자열 분리, 쉼표를 구분자로 숫자를 분리한다")
    public void split_쉼표구분자() {
        Splitter splitter = new Splitter();
        List<String> result = splitter.split("1,2", ",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("문자열 분리, 쉼표 또는 콜론을 구분자로 숫자를 분리한다")
    public void split_쉼표_또는_콜론_구분자() {
        Splitter splitter = new Splitter();
        List<String> result = splitter.split("1,2:3", ",|:");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("문자열 분리, 커스텀 구분자로 숫자를 분리한다")
    public void split_custom_구분자()  {
        Splitter splitter = new Splitter();
        List<String> result = splitter.split("1;2;3", ";");
        assertThat(result).containsExactly("1", "2", "3");
    }


    @Test
    @DisplayName("문자열 분리, 쉼표, 콜론, 커스텀 구분자로 숫자를 분리한다")
    public void split_custom_구분자_또는_쉼표_콜론_구분자()  {
        Splitter splitter = new Splitter();
        List<String> result = splitter.split("1;2;3,4:5", ",|:|;");
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


    @Test
    @DisplayName("문자열 합계, 문자열 전달시 구분자를 기준으로 분리하여 합계를 구한다")
    public void splitAndSum(){
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        int result = stringAddCalculator.calculator("//;\n1;2;3,4:5");
        assertThat(result).isEqualTo(15);
    }
}
