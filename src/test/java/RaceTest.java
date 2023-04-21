import model.AlwaysMoveStrategy;
import model.Race;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    @Test
    public void carsAreCreated() {
        var numberOfCars = 3;
        var race = new Race();
        race.resetWithCarsOf(3);
        assertThat(race.getCarPositions()).hasSize(numberOfCars);
        assertThat(race.getCarPositions()).containsExactly(0, 0, 0);
    }

    @Test void carsMove() {
        var numberOfCars = 3;
        var steps = 5;
        var strategy = new AlwaysMoveStrategy();

        var race = new Race();
        race.resetWithCarsOf(numberOfCars);
        for (int i = 0; i<steps;++i) {
            race.progress(strategy);
        }

        for (var carPosition : race.getCarPositions()) {
            assertThat(carPosition).isEqualTo(steps);
        }
    }
}
