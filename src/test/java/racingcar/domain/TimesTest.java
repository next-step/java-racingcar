package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class TimesTest {

    @Test
    public void 음수를_입력했을때_에러가_발생하는지_확인() {
        assertThatThrownBy(() -> new Times(-5))
          .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 영을_입력했을때_에러가_발생하는지_확인() {
        assertThatThrownBy(() -> new Times(0))
          .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 올바르게_횟수를_반환하는지_확인() {
        Times times = new Times(3);
        assertThat(3).isEqualTo(times.getTimes());
    }
}