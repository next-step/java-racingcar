package study;

import calculator.StringAddCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {

    StringAddCalculator stringAddCalculator = new StringAddCalculator();
    @ParameterizedTest
    @NullSource
    @EmptySource
    public void splitAndSum_null_또는_빈문자(String data){
        int result = stringAddCalculator.splitAndSum(data);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception{
        int result = stringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception{
        int result = stringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2:3", "1,2,3", "1:2:3"})
    public void splitAndSum_쉼표_또는_콜론_구분자(String data) throws Exception{
        int result = stringAddCalculator.splitAndSum(data);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_구분자() throws Exception{
        int result = stringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_음수_입력시_에러발생() throws Exception{
        assertThatThrownBy(() -> stringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageStartingWith("음수가 들어왔습니다");
    }


}