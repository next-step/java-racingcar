import model.AlwaysMoveStrategy;
import model.Race;
import org.assertj.core.data.MapEntry;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    @Test
    public void carsAreCreated() {
        var numberOfCars = 3;
        var carNames = List.of("car1", "car2", "car3");
        var race = new Race();
        race.resetWithCarsOf(carNames);
        assertThat(race.getCarPositions()).hasSize(numberOfCars);
        assertThat(race.getCarPositions()).containsExactlyInAnyOrderEntriesOf(Map.of(
                carNames.get(0), 0,
                carNames.get(1), 0,
                carNames.get(2), 0
        ));
    }

    @Test void carsMove() {
        var carNames = List.of("car1", "car2", "car3");
        var steps = 5;
        var strategy = new AlwaysMoveStrategy();

        var race = new Race();
        race.resetWithCarsOf(carNames);
        for (int i = 0; i<steps;++i) {
            race.progress(strategy);
        }

        for (var carPosition : race.getCarPositions().values()) {
            assertThat(carPosition).isEqualTo(steps);
        }
    }
}
