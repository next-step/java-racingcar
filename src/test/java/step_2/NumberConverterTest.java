package step_2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberConverterTest {

    @Test
    void 문자열_배열_숫자형으로_컨버팅() {
        assertThat(NumberConverter.toInts().apply(List.of("1", "2", "3"))).isNotEmpty().isEqualTo(List.of(1, 2, 3));
    }

    @Test
    void 음수_예외_처리() {
        assertThatThrownBy(() -> NumberConverter.toInts().apply(List.of("-1", "-2", "-3"))).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}