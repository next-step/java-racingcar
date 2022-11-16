package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

public class PositiveTest {
    @Test
    public void 문자로_생성() {
        assertThat(Positive.from("1")).isEqualTo(Positive.from("1"));
    }

    @Test
    public void 숫자로_생성() {
        assertThat(new Positive(365).getNumber()).isEqualTo(365);
    }

    @Test
    public void 덧셈() {
        var positive = Positive.from("1");
        assertThat(positive.plus(5)).isEqualTo(6);
    }

    @Test
    public void 객체간_덧셈() {
        var positive1 = Positive.from("2");
        var positive2 = Positive.from("3");
        assertThat(positive1.plus(positive2)).isEqualTo(5);
    }

    @Test
    public void 음수() {
        assertThatThrownBy(() -> {
            Positive.from("-1");
        }).isInstanceOf(RuntimeException.class);
    }
}
