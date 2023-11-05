package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("빈 문자열 또는 null을 입력하는 경우 0을 반환한다.")
    void splitAndSumNullAndBlankTest(){
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("하나의 숫자를 입력할 경우 해당 숫자를 반환한다.")
    void splitAndSumOneIntegerTest(){
        int result = StringAddCalculator.splitAndSum("3");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자 콤마(,)를 사용할 수 있다.")
    void splitCommaAndSumTest(){
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자 콜론(:)을 사용할 수 있다.")
    void splitCommaOrColonAndSumTest(){
        int result = StringAddCalculator.splitAndSum("1:2,3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("//, \\n 사이에 커스텀 구분자를 사용할 수 있다.")
    void splitCustomDelimiterAndSumTest(){
        int result = StringAddCalculator.splitAndSum("//?\n1?2?3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자 이외의 값과 음수인 경우 RuntimeException 예외가 발생한다.")
    void NotNumberOrNegativeErrorTest(){
        assertThrows(RuntimeException.class, () -> StringAddCalculator.splitAndSum("a:1:2"));
    }


    @Test
    void customDelimiterTest() {
        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = pattern.matcher("//?\n1?2?");
        if (matcher.find()) {
            System.out.println("matcher = " + matcher.group(1));
            String[] result = matcher.group(2).split("\\" + matcher.group(1));
            System.out.println("matcher.group(2).split(math) = " + result);
            for (String s : result) {
                System.out.println("s = " + s);
            }
        }
        
        
    }
    @Test
    void splitTest(){
        String str = "1,2";
        String[] numbers = str.split(",");
        assertThat(numbers).containsExactly("1", "2");
    }

    @Test
    void separatorsTest(){
        String str = "1,2:3";
        String[] result = str.split(",|:");
        assertThat(result).containsExactly("1","2","3");

    }
}
