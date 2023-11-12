package carracing;

import carracing.domain.car.RaceCars;
import carracing.domain.race.Race;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    private static final List<String> carNames = List.of("pobi", "edu");

    @Test
    @DisplayName("생성/자동차2대 생성/2대 생성된다.")
    void createTrack() {
        Race race = new Race(RaceCars.makeCars(carNames));
        assertThat(race.carHistory().getCars()).hasSize(2);
    }
}
