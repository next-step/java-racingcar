package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @Test
    @DisplayName("빈 문자열이나 null일 경우 0을 리턴한다.")
    void 빈_문자열이나_null_일경() {
        assertThat(StringAddCalculator.splitAndSum("")).isZero();
        assertThat(StringAddCalculator.splitAndSum(null)).isZero();
    }

    @Test
    @DisplayName("쉼표 구분자는 split이 된다.")
    void 쉼표_구분자는_Split이_된다() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("컬럼 구분자는 split이 된다.")
    void 컬럼_구분자는_Split이_된다() {
        assertThat(StringAddCalculator.splitAndSum("1:2")).isEqualTo(3);
    }

    @Test
    @DisplayName("커스텀 구분자는 split이 된다.")
    void 커스텀_구분자는_Split이_된다() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("기본 구분자이고 음수가 포함되어있을때 에러를 던진다.")
    void 기본_구분자이고_음수가_있을떄_에러를_던진다() {
        assertThatThrownBy(() -> {
            StringAddCalculator.splitAndSum(("-1,2:3"));
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("커스 구분자이고 음수가 포함되어있을때 에러를 던진다.")
    void 커스텀_구분자이고_음수가_있을떄_에러를_던진다() {
        assertThatThrownBy(() -> {
            StringAddCalculator.splitAndSum(("//;\n1;-2;3"));
        }).isInstanceOf(RuntimeException.class);
    }
}
