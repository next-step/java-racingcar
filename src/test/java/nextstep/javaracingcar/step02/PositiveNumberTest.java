package nextstep.javaracingcar.step02;

import nextstep.javaracingcar.step2.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static nextstep.javaracingcar.step2.PositiveNumber.from;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositiveNumberTest {

    @DisplayName("문자열을 입력해서 생성할 수 있다.")
    @Test
    public void spec01() {
        assertThat(from("1")).isEqualTo(from(1));
    }

    @DisplayName("음수는 허용되지 않는다.")
    @Test
    public void spec02() {
        assertThatThrownBy(() -> from("-1")).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> from(-1)).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("더할 수 있다.")
    @Test
    public void spec03() {
        final PositiveNumber one = from("1");
        assertThat(one.plus(one)).isEqualTo(from("2"));
    }
}
