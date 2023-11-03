package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringCalculatorTest {

    @Test
    void 문자열_비어있는지_확인() {
        int result = StringCalculator.cal(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 문자열_길이가_1일때_덧셈_테스트() {
        int result = StringCalculator.cal("2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 문자열_길이가_2이상_일반구분자_덧셈() {
        int result = StringCalculator.cal("1,2,3");
        int result2 = StringCalculator.cal("1,2:3");
        assertThat(result).isEqualTo(6);
        assertThat(result2).isEqualTo(6);
    }

    @Test
    void 문자열_길이_2이상_특수구분자_덧셈() {
        int result = StringCalculator.cal("//-\n1-2-3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 숫자_이외의_값이면_에러발생() {
        // 일반 구분자일 때
        assertThrows(RuntimeException.class, () -> StringCalculator.cal("1;-;3"));

        //특수 구분자 일 떄
        assertThrows(RuntimeException.class, () -> StringCalculator.cal("//;\n1;-;3"));
    }

    @Test
    void 음수값이면_에러발생() {
        // 일반 구분자일 때
        assertThrows(RuntimeException.class, () -> StringCalculator.cal("1;-2;3"));

        // 특수 구분자 일 떄
        assertThrows(RuntimeException.class, () -> StringCalculator.cal("//;\n1;-2;3"));
    }
}
