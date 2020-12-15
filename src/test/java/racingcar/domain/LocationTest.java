package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LocationTest {

    @Test
    void 자동차_위치_생성() {
        assertThat(new Location(1)).isEqualTo(new Location(1));
    }

    @Test
    void 자동차_위치_이동() {
        Location location = new Location(1);
        location.moveLocation();
        assertThat(location.getLocationValue()).isEqualTo(2);
    }
}
