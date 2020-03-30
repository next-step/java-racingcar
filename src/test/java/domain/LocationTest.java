package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LocationTest {

    private Location location;

    @BeforeEach
    public void setup() {
        location = new Location();
    }

    @Test
    public void canNotCreateLocationWithNegativeNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Location(-1));
    }

    @Test
    public void moveForwardTest() {
        location.moveToForward();
        location.moveToForward();
        assertThat(location).isEqualTo(new Location(2));
    }

    @Test
    public void equalTest() {
        assertThat(new Location()).isEqualTo(new Location());
        assertThat(new Location()).isEqualTo(new Location(0));
    }

}
