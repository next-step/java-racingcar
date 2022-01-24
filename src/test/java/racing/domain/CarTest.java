package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차_이름_길이_확인() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Car("abcdef"));
    }
}