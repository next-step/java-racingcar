import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LocationTest {
    @Test
    void 값_1_증가() {
        Location location = new Location(0);
        location.add(1);
        assertThat(location.getValue()).isEqualTo(1);
    }

    @Test
    void 동일한_값() {
        Location location = new Location(2);
        assertThat(location.isSame(2)).isTrue();
        assertThat(location.isSame(3)).isFalse();
    }
}
