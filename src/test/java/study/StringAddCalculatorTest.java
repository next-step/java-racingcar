package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {

    //Test Case
    @Test
    @DisplayName("1. 빈 문자열, null => 0으로 반환")
    void Empty() {
        assertThat(Calculator.splitSum(null)).isEqualTo(0);
        assertThat(Calculator.splitSum("")).isEqualTo(0);
    }

    @DisplayName("2. 숫자 하나 입력 시 숫자 반환")
    @Test
    void Number() {
        assertThat(Calculator.splitSum("1")).isEqualTo(1);
    }


    @Test
    @DisplayName("3. 숫자 여러개 입력 시 구분자로 구분하여 숫자들의 합 반환")
    void Array() {
        assertThat(Calculator.splitSum("1,2")).isEqualTo(3);
        assertThat(Calculator.splitSum("1,2,3")).isEqualTo(6);
    }

    //4. ,:로 들어왔을 때 구분하여 숫자더하기
    @Test
    @DisplayName("4. 구분자 추가")
    void SplitAdd() {
        assertThat(Calculator.splitSum("1,2:3")).isEqualTo(6);
    }


    @Test
    @DisplayName("5. 커스텀구분자 추가")
    void CumstomSplit() {
        int result = Calculator.splitSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);

    }

    @Test
    @DisplayName("음수는 RuntimeException 예외 처리")
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> Calculator.splitSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
