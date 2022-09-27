package calculator;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.StringAddCalculator.splitAndSum;
import static org.assertj.core.api.Assertions.*;

/**
 * # 기능 요구사항 <br>
 * 1. 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 <br>
 *  (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6) <br>
 * <br>
 * 2. 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. <br>
 *  커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. <br>
 *  예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다. <br>
 * <br>
 * 3. 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다. <br>
 * <br>
 * <br>
 * # 프로그래밍 요구사항 <br>
 *   - 메소드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다. <br>
 */
public class StringAddCalculatorTest {

    @Test
    void 구분자로_분리한_숫자의_합_반환() {
        String[] result = "".split(",");
    }

    @Test
    void null_or_space() {
        assertThat(splitAndSum("")).isEqualTo(0);
        assertThat(splitAndSum(null)).isEqualTo(0);
    }

    @Test
    void 문자열_하나() {
        assertThat(splitAndSum("1")).isEqualTo(1);
    }

    @Test
    void 문자열_쉼표_구분자() {
        assertThat(splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void 문자열_쉼표_콜론_구분자() {
        assertThat(splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void 커스컴_구분자_컴파일() {
        String input = "//;\n1;2;3";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String delimiter = m.group(1);
            String[] tokens = m.group(2).split(delimiter);

            assertThat(tokens).isEqualTo(new String[] { "1", "2", "3" } );
        }
    }

    @Test
    void 커스텀_구분자() {
        assertThat(splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void 숫자_음수() {
        assertThatThrownBy(() -> {
           splitAndSum("1,2:-3");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 숫자_이외의_값() {
        assertThatThrownBy(() -> {
           splitAndSum("1,2:#");
        }).isInstanceOf(RuntimeException.class);
    }
}
