package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.StringAddCalculator.splitAndSum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
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

    @Test
    @DisplayName("null 또는 space일 때")
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
    void 문자열_콜론_구분자() {
        assertThat(splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void 숫자_음수() {
        assertThatThrownBy(() -> {
            splitAndSum("1,-1");
        }).isInstanceOf(RuntimeException.class);
    }

    //---
    // given when then을 주석으로 다는 것을 권장하지 않음(가독성 차원)
//    @Test
//    void 문자열_하나(){
//        //given
//        String value = "1";
//
//        //when
//        int result = calculate("1");
//
//        //then
//        assertThat(result).isEqualTo(1);
//    }

    // 테스트명이나 디스플레이네임이 값과 의존성이 없도록 하기
    // expected 값이 변경되는 경우 함수명도 같이 변경해야함
//    @Test
//    void 문자열_하나_1일때_1을_반환(){ // worst naming case
//        assertThat(calculate("1")).isEqualTo(1);
//    }

}
