package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StringAddCalculatorTest {

    @Test
    public void splitAndSum_null() {
        //given

        //when
        int result = StringAddCalculator.splitAndSum(null);

        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_빈문자() {
        //given

        //when
        int result = StringAddCalculator.splitAndSum("");

        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        //given

        //when
        int result = StringAddCalculator.splitAndSum("1");

        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        //given

        //when
        int result = StringAddCalculator.splitAndSum("1,2");

        //then
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        //given

        //when
        int result = StringAddCalculator.splitAndSum("1,2:3");

        //then
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        //given

        //when
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");

        //then
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_음수포함() throws Exception {
        //given

        //when

        //then
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수는 입력할 수 없습니다.");
    }
}