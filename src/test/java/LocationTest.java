import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LocationTest {

    @Test
    @DisplayName("Location 객체는 음수 값을 가질 수 없다.")
    void invalidLocationTest() {
        assertThatThrownBy(() -> new Location(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Location은 0 이상의 값이어야 합니다.");
    }

    @Test
    @DisplayName("Location을 앞으로 한 칸 움직이면 값이 1 증가한다.")
    void moveForward() {
        Location location = new Location(1);
        location.moveForward();
        assertThat(location).isEqualTo(new Location(2));
    }
}