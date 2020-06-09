package autoracing.view;

import autoracing.domain.Car;
import autoracing.domain.Location;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTrackRendererTest {
    @Test
    public void renderTest() {
        Car car = Car.createWithHistory("KIA", () -> false, Collections.singletonList(Location.STARTING_LINE.move(2)));
        CarTrackRenderer renderer = new CarTrackRenderer("O", "|", "-");
        assertThat(renderer.render(car, 0, 3)).isEqualTo("KIA|--O");
    }
}
