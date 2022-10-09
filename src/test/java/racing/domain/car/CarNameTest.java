package racing.domain.car;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @Test
    void 다섯글자_초과한_이름은_쓸_수_없다() {
        assertThatThrownBy(() -> new CarName("abcdefg")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 빈값은_이름이_될_수_없다() {
        assertThatThrownBy(() -> new CarName("")).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullSource
    void null은_이름이_될_수_없다(String nullSource) {
        assertThatThrownBy(() -> new CarName(nullSource)).isInstanceOf(IllegalArgumentException.class);
    }
}
