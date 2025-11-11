package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class NumbersTest {

    @Test
    void 문자가_존재한다면_예외가_발생한다() {
        assertThatThrownBy(() -> new Numbers(List.of("넥스트스텝", "tdd", "화이팅")))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("숫자가 아닌 값이 포함되어 있습니다.");
    }

    @Test
    void 음수가_존재한다면_예외가_발생한다() {
        assertThatThrownBy(() -> new Numbers(List.of("-1", "2", "3")))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수가 포함되어 있습니다.");
    }

    @Test
    void 숫자_리스트의_합을_반환한다() {
        Numbers numbers = new Numbers(List.of("1", "2", "3"));
        assertThat(numbers.sum()).isEqualTo(6);
    }
}
