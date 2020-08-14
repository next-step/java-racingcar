package pobiRacingCar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {
    @Test
    void doCreateCarName() {
        CarName name = new CarName("pobi");
        assertThat(new CarName("pobi")).isEqualTo(new CarName("pobi"));
    }

    @Test
    void invalidCarName() {
        assertThatThrownBy(() -> new CarName(null).isInstanceOf(IllegalArgumentException.class));
        assertThatThrownBy(() -> new CarName("").isInstanceOf(IllegalArgumentException.class));
        assertThatThrownBy(() -> new CarName("  ").isInstanceOf(IllegalArgumentException.class));
    }
}
