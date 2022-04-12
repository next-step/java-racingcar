package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    /*
    1. 실패하는 테스트 만들어
    2. 구현클래스, 메소드 이름 신경쓰지말고 막지어
    3. 실패테스트 해봐
    4. 성공하게끔 수정해봐
    5. 이제 네이밍제대로 해봐
     */

    @Test
    void 일단실패테스트만들어() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 널_OR_빈_문자열_OR_공백문자_일떄() {
        int result = 0;
        result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 널_OR_빈_문자열_OR_공백문자_일떄2() {
        //로컨변수 없이 간단하게도 좋다
        assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0);
        assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0);
    }
//
    @Test
    void 문자열숫자_하나만_입력() {
        assertThat(StringAddCalculator.splitAndSum("1")).isEqualTo(1);
    }
//
    @Test
    void 쉼표_구분자() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }
//
    @Test
    void 콜론_구분자() {
        assertThat(StringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }
//
    @Test
    void 커스텀_구분자() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }
//
    @Test
    void 음수_기본구분자() {
        assertThatThrownBy(()->{
           StringAddCalculator.splitAndSum("-1:2,3");
        }).isInstanceOf(RuntimeException.class);
    }
//
//    @Test
//    void 음수_커스텀구분자() {
//        assertThatThrownBy(()->{
//            StringAddCalculator.splitAndSum("//;\n-1;2;3");
//        }).isInstanceOf(RuntimeException.class);
//    }


}
