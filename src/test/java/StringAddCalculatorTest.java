import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {
    //클래스명이 무엇인지 메서드명이 무엇인지 중요하지 않다. -> 나중에 설계 영역으로 넘어가도 좋다.
    //input과 output을 잘 정하는 것이 중요하다.
    //프로덕션코드(실제 동작하는 로직)가 아직 구현되지 않았기 때문에 처음에는 무조건 컴파일 에러가 난다.
    //프로덕션코드를 만들어준다.
    @Test
    void 빈문자열이거나_null일_경우() {
        assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0);
        assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0);
    }

    @Test
    void 쉼표_구분자() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @DisplayName("커스텀 구분자는 '//'과 '\n' 사이에 위치하는 문자이다")
    @Test
    void 커스텀_구분자를_사용할_수_있다() {
        assertThat(StringAddCalculator.splitAndSum("//:\n1:2")).isEqualTo(3);
    }
}
