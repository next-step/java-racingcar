package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LocationTest {

    @Test
    @DisplayName("랜덤값이 4이상이면 전진한다")
    void advanceSuccessTest() {
        Location location = new Location(1);
        assertThat(location.move(4)).isEqualTo(new Location(2));
    }

    @Test
    @DisplayName("랜덤값이 4미만이면 전진하지않는다")
    void advanceFailTest() {
        Location location = new Location(1);
        assertThat(location.move(3)).isEqualTo(new Location(1));
    }
}