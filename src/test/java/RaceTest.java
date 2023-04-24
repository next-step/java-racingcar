import model.AlwaysMoveStrategy;
import model.Race;
import model.SelectedCarsMoveStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @Test
    void carsMove() {
        var carNames = List.of("car1", "car2", "car3");
        var steps = 5;
        var strategy = new AlwaysMoveStrategy();

        var race = new Race();
        race.resetWithCarsOf(carNames);
        for (int i = 0; i < steps; ++i) {
            race.progress(strategy);
        }

        for (var carPosition : race.getCarPositions().values()) {
            assertThat(carPosition).isEqualTo(steps);
        }
    }

    @Test
    void findSingleWinner() {
        var carNames = List.of("car1", "car2", "car3", "car4");
        var carsToMove = Set.of("car2");
        var steps = 5;
        var strategy = new SelectedCarsMoveStrategy(carsToMove);

        var race = new Race();
        race.resetWithCarsOf(carNames);
        for (int i = 0; i < steps; ++i) {
            race.progress(strategy);
        }

        var result = race.getWinnerNames();
        assertThat(result).containsExactly("car2");
    }

    @Test
    void findMultipleWinners() {
        var carNames = List.of("car1", "car2", "car3", "car4");
        var carsToMove = Set.of("car2", "car4");
        var steps = 5;
        var strategy = new SelectedCarsMoveStrategy(carsToMove);

        var race = new Race();
        race.resetWithCarsOf(carNames);
        for (int i = 0; i < steps; ++i) {
            race.progress(strategy);
        }

        var result = race.getWinnerNames();
        assertThat(result).contains("car2", "car4");
    }
}
