import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculateTest {
    @Test
    void null_값() {
        int value = Calculator.calculate("");
        assertThat(value).isEqualTo(0);
    }

    @Test
    void 숫자_하나() {
        int value = Calculator.calculate("1");
        assertThat(value).isEqualTo(1);
    }

    @Test
    void 숫자_둘_구분자_컴마() {
        int value = Calculator.calculate("1,2");
        assertThat(value).isEqualTo(3);
    }

    @Test
    void 숫자_둘_구분자_콜론() {
        int value = Calculator.calculate("1:2");
        assertThat(value).isEqualTo(3);
    }

    @Test
    void 커스텀_구분자() {
        int value = Calculator.calculate("//;\n1;2;3");
        assertThat(value).isEqualTo(6);
    }

    @Test
    void 음수_값() {
        int value = Calculator.calculate("-1");
        assertThatThrownBy(() -> {
           throw new RuntimeException();
        });
    }
}
