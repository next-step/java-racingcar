import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class StringAddCalculatorTest {

    @DisplayName("빈 문자열 혹은 null을 입력받으면 0을 리턴한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void shouldReturnZero_whenInputEmptyStringOrNull(String input) {
        //given
        int expectedResult = 0;
        //when
        int answer = StringAddCalculator.splitAndSum(input);
        //then
        assertThat(answer).isEqualTo(expectedResult);
    }

    @Test
    void shouldReturnSix_whenInputString() {
        //given
        String example = "1:2,3";
        int expectedResult = 6;
        //when
        int answer = StringAddCalculator.splitAndSum(example);
        //then
        assertThat(answer).isEqualTo(expectedResult);
    }

    @Test
    void shouldReturnTen_whenUsingSemicolonAndBracketsAsSeparators() {
        //given
        String example = "//}\n1}2:3}4";
        int expectedResult = 10;
        //when
        int answer = StringAddCalculator.splitAndSum(example);
        //then
        assertThat(answer).isEqualTo(expectedResult);
    }
    
    @Test
    void throwRunTimeException_whenPassExceptNumberOrNegativeNumber(){
        //given
        String exampleExceptNumbersOrNegativeNums = "1,2,-1,d";
        //when & then
        assertThatThrownBy(() -> {
            int answer = StringAddCalculator.splitAndSum(exampleExceptNumbersOrNegativeNums);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void throwRunTimeException_whenPassNegativeNumber() throws Exception {
        //given
        String exampleExceptNumbersOrNegativeNums = "1,2,-1";
        //when & then
        assertThatThrownBy(() -> {
            int answer = StringAddCalculator.splitAndSum(exampleExceptNumbersOrNegativeNums);
        }).isInstanceOf(RuntimeException.class);
    }


    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
            .isInstanceOf(RuntimeException.class);
    }
}
