package calculator;

import org.junit.jupiter.api.Test;

import java.sql.Array;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @Test
    void 빈_문자열이나_null_일경우() {
        assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0);
        assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0);
    }

    @Test
    void 쉼표_구분자() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void 컬럼_구분자를() {
        assertThat(StringAddCalculator.splitAndSum("1:2")).isEqualTo(3);
    }

    @Test
    void 커스텀_구분자() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void 기본_구분자이고_음수가_있을떄_에러를_던진다() {
        assertThatThrownBy(() -> {
            StringAddCalculator.splitAndSum(("-1,2:3"));
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 커스텀_구분자이고_음수가_있을떄_에러를_던진다() {
        assertThatThrownBy(() -> {
            StringAddCalculator.splitAndSum(("//;\n1;-2;3"));
        }).isInstanceOf(RuntimeException.class);
    }



}
