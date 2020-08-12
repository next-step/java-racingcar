package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {
    @Test
    void 자동차이름_객체_생성() {
        assertThat(new CarName("애플")).isEqualTo(new CarName("애플"));
    }

    @Test
    void 자동차이름_유효성검사() {
        assertThatThrownBy(() -> new CarName(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new CarName("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new CarName(" ")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new CarName("123456")).isInstanceOf(IllegalArgumentException.class);
    }
}
