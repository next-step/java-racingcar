package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.exception.NegativeNumberException;

public class PositiveTest {

    @Test
    @DisplayName("생성자에 ")
    void create1() {
        assertThat(new Positive("1")).isEqualTo(new Positive(1));
    }

    @Test
    @DisplayName("생성자에 음수를 입력하면 예외가 발생한다.")
    void create2() {
        assertThatExceptionOfType(NegativeNumberException.class)
            .isThrownBy(() -> new Positive("-1"))
            .withMessageMatching("음수는 입력할 수 없습니다.");
    }
}
