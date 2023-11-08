package carracing;

import carracing.domain.car.Cars;
import carracing.domain.race.CarRace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRaceTest {
    private static final List<String> carNames = List.of("pobi", "edu");

    @Test
    @DisplayName("생성/자동차N대 생성/생성된다.")
    void createTrack() {
        CarRace carRace = new CarRace(Cars.makeCars(carNames));
        assertThat(carRace).isInstanceOf(CarRace.class);
    }
}
