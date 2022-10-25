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
        Location location = new Location(1);
        location.next();
        assertThat(location).isEqualTo(new Location(2));
    }

    @Test
    @DisplayName("위치 값이 더 크면 1을 반환한다.")
    void compare_bigger_location() {
        assertThat(new Location(3).compareTo(new Location(1))).isEqualTo(1);
    }

    @Test
    @DisplayName("위차 값이 더 작으면 -1을 반환한다.")
    void compare_small_location() {
        assertThat(new Location(1).compareTo(new Location(3))).isEqualTo(-1);
    }

    @Test
    @DisplayName("위치 값이 같으면 0을 반환한다.")
    void compare_same_location() {
        assertThat(new Location(1).compareTo(new Location(1))).isEqualTo(0);
    }
}
