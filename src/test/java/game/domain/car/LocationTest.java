package game.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LocationTest {

    @Test
    void create(){
        Location location = new Location(5);

        Assertions.assertThat(location).isEqualTo(new Location(5));
    }

    @Test
    void valid(){
        Assertions.assertThatThrownBy(() -> new Location(-1)).isInstanceOf(IllegalArgumentException.class);
    }
}
