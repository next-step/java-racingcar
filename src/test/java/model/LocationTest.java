package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LocationTest {

    @Test
    void 증가한다() {
        // given
        final Location location = new Location(0);

        // when
        location.increase();

        // then
        assertThat(location.getValue()).isEqualTo(1);
    }
}
