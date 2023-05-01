package carracing;

import carracing.domain.Location;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LocationTest {
    @Test
    @DisplayName("위치값 음수 익셉션 테스트")
    void minusLocationTest() {
        Assertions.assertThatThrownBy(() -> {
                    new Location(-1);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("위치값은 음수일 수 없습니다.");
    }

    @Test
    @DisplayName("위치 증가 테스트")
    void locationIncreaseTest() {
        Location location = new Location(1);
        location.increase();
        assertThat(location.getLocation()).isEqualTo(2);
    }

    @Test
    @DisplayName("같은 위치값인지 확인 테스트")
    void sameLocationTest() {
        Location location = new Location(3);
        assertThat(location.isSame(3)).isTrue();
    }

    @Test
    @DisplayName("다른 위치값인지 확인 테스트")
    void notSameLocationTest() {
        Location location = new Location(3);
        assertThat(location.isSame(4)).isFalse();
    }
}
