package study.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import study.calculator.StringAddCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringAddCalculatorTest {

    StringAddCalculator stringAddCalculator;

    @BeforeEach
    public void beforeEach(){
        stringAddCalculator = new StringAddCalculator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열 또는 null을 입력하는 경우 0을 반환한다.")
    void splitAndSumNullAndBlankTest(String input) {
        int result = stringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("하나의 숫자를 입력할 경우 해당 숫자를 반환한다.")
    void splitAndSumOneIntegerTest() {
        int result = stringAddCalculator.splitAndSum("3");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자 콤마(,)를 사용할 수 있다.")
    void splitCommaAndSumTest() {
        int result = stringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자 콜론(:)을 사용할 수 있다.")
    void splitCommaOrColonAndSumTest() {
        int result = stringAddCalculator.splitAndSum("1:2,3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("//, \\n 사이에 커스텀 구분자를 사용할 수 있다.")
    void splitCustomDelimiterAndSumTest() {
        int result = stringAddCalculator.splitAndSum("//?\n1?2?3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자 이외의 값과 음수인 경우 RuntimeException 예외가 발생한다.")
    void NotNumberOrNegativeErrorTest() {
        assertThrows(RuntimeException.class, () -> stringAddCalculator.splitAndSum("-1:1:2"));
    }

    @Test
    void customDelimiterTest() {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher("//?\n1?2?A");
        if (matcher.find()) {
            System.out.println("matcher = " + matcher.group(1));
            String[] result = matcher.group(2).split("\\" + matcher.group(1));
            for (String s : result) {
                System.out.println("s = " + s);
            }
        }
    }

    @Test
    void splitTest() {
        String str = "1,2";
        String[] numbers = str.split(",");
        assertThat(numbers).containsExactly("1", "2");
    }

    @Test
    void separatorsTest() {
        String str = "1,2:3";
        String[] result = str.split(",|:");
        assertThat(result).containsExactly("1", "2", "3");
    }
}
