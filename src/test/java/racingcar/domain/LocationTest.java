package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LocationTest {

    @Test
    @DisplayName("위치는 0보다 작을 수 없습니다.")
    void location_under_zero() {
        assertThatThrownBy(() -> new Location(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("위치는 0보다 작을 수 없습니다.");
    }

    @Test
    @DisplayName("다음 위치는 기존 값에 1을 더한다.")
    void next_location() {
        assertThat(new Location(1).next()).isEqualTo(new Location(2));
    }
}
