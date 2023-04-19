package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step2.StringCalculator.splitAndSum;


public class StringCalculatorTest {

    @DisplayName("음수를 전달할 경우 IllegalArgumentException 예외가 발생")
    @Test
    void test6() {
        assertThatThrownBy(() -> {
            splitAndSum("-1,2:3");
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다")
    @Test
    void test5() {
        assertThat(splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다")
    @Test
    void Test4() {
        assertThat(splitAndSum("1,2:3")).isEqualTo(6);
    }

    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환")
    @Test
    void test3() {
        assertThat(splitAndSum("1,2")).isEqualTo(3);
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
    @Test
    void test2() {
        assertThat(splitAndSum("1")).isEqualTo(1);
    }


    @DisplayName("빈 문자열 또는 null 값을 입력할 때 0 반환")
    @NullAndEmptySource
    @ParameterizedTest(name = "{displayName} {index} = 입력: {0} -> 결과: 0")
    void test1(String input) {
        assertThat(splitAndSum(input)).isEqualTo(0);
    }

}
