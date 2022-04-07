package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CTest {
    @Test
    void 빈_문자열_공백문자_일때() {
        assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0);
        assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0);
    }

    @Test
    void 쉼표_구분자() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void 콜론_구분자(){
        assertThat(StringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }
    @Test
    void 커스텀_구분자(){
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }


    @Test
    void 문자_기본구분자(){
        assertThatThrownBy(()->{
            StringAddCalculator.splitAndSum("-1;2;3");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 음수_커스텀구분자(){
        assertThatThrownBy(()->{
            StringAddCalculator.splitAndSum("//;\n-1;2;3");
        }).isInstanceOf(RuntimeException.class);
    }

}
