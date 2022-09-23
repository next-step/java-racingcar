package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.exception.NegativeNumberException;

public class PositiveTest {

    @Test
    @DisplayName("문자열과 숫자를 통해 생성된 Positive 객체는 같은 객체이다.")
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

    @Test
    @DisplayName("값 객체를 더하게 되면 더한 값을 갖는 Positive 객체가 반환된다.")
    void sum() {
        Positive positive1 = new Positive("1");
        Positive positive2 = new Positive("2");
        assertThat(positive1.plus(positive2)).isEqualTo(new Positive(3));
    }
}
