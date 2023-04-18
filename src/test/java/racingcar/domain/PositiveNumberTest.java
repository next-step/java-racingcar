package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositiveNumberTest {

    @Test
    void create() {
        PositiveNumber positiveNumber = PositiveNumber.create("3");
        assertThat(positiveNumber.getNumber()).isEqualTo(3);
    }

    @Test
    void create_음수를_전달하면_IllegalArgumentException() {
        assertThatThrownBy(() -> PositiveNumber.create("-3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수는 입력할 수 없습니다.");
    }

    @Test
    void create_숫자_이외의_값을_전달하면_NumberFormatException() {
        assertThatThrownBy(() -> PositiveNumber.create("HELLO"))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("숫자 이외의 값은 입력할 수 없습니다.");
    }
}
