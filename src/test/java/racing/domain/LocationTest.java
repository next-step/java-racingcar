package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LocationTest {
    @DisplayName("forward하면 위치가 1 증가한다.")
    @Test
    void forward() {
        final Location location = new Location(0);

        assertThat(location.forward()).isEqualTo(new Location(1));
    }

    @DisplayName("위치는 0 미만일 수 없다.")
    @Test
    void defaultLocation() {
        assertThatThrownBy(() -> new Location(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("위치는 0이상이어야 합니다.");
    }
}
