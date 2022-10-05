package racing.domain.car;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    void 다섯글자_초과한_이름은_쓸_수_없다() {
        assertThatThrownBy(() -> new Name("abcdefg")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 빈값은_이름이_될_수_없다() {
        assertThatThrownBy(() -> new Name("")).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullSource
    void null은_이름이_될_수_없다(String nullSource) {
        assertThatThrownBy(() -> new Name(nullSource)).isInstanceOf(IllegalArgumentException.class);
    }
}
