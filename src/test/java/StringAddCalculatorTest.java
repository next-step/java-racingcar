import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;


public class StringAddCalculatorTest {

    @Test
    void shouldReturnZero_whenInputEmptyStringOrNull() {
        //given
        String emptyString = "";
        int expectedResult = 0;
        //when
        int answer1 = StringAddCalculator.splitAndSum(emptyString);
        int answer2 = StringAddCalculator.splitAndSum(null);
        
        //then
        assertThat(answer1).isEqualTo(expectedResult);
        assertThat(answer2).isEqualTo(expectedResult);
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
        String example = "//;}\n1;2;3}4";
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
