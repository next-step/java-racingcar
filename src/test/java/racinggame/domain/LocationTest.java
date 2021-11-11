package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LocationTest {

    @DisplayName("생성된 위치가 맞는지 테스트")
    @Test
    void createLocationCheck() {
        int expected = 2;

        Location location = new Location(expected);

        assertThat(location).isNotNull();
        assertThat(location.getLocation()).isEqualTo(expected);
    }

    @DisplayName("생성된 위치에서 앞으로 이동하는지 테스트")
    @Test
    void locationMovingTest() {
        int actual = 2;
        int excepted = 3;

        Location location = new Location(actual);
        assertThat(location).isNotNull();

        location.move();
        assertThat(location.getLocation()).isEqualTo(excepted);
    }
}
