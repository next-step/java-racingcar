package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.domain.Position;
import study.racingcar.domain.Time;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class TimeTest {
    @DisplayName("생성시 넘겨준 값을 변경 없이 그대로 유지할 수 있다.")
    @Test
    void value() {
        Time position = new Time(1);
        assertThat(position.getTime()).isEqualTo(1);
    }

    @DisplayName("0 이하의 값을 입력할 수 없다.")
    @Test
    void canNotBeLessThenOne() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Time(0);
                });
    }
}
