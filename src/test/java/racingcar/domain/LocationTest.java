package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LocationTest {
    @Test
    void goForward() {
        int loc = 2;
        Location location = new Location(loc);

        assertThat(location.goForward()).isEqualTo(new Location(loc + 1));
    }

    @Test
    void validateLocation() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Location location = new Location(-1);
                });

        assertThat(new Location(0));
    }

    @Test
    void toStringTest() {
        assertThat(new Location(5).toString()).isEqualTo("-----");
        assertThat(new Location(7).toString()).isEqualTo("-------");
    }
}
