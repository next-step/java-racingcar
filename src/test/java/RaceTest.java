import model.Race;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    @Test
    public void nCarsAreCreated() {
        var numberOfCars = 3;
        var race = new Race();
        race.resetWithCarsOf(3);
        assertThat(race.getCarPositions()).hasSize(numberOfCars);
        assertThat(race.getCarPositions()).containsExactly(0, 0, 0);
    }

    @Test void carsMove() {
        var numberOfCars = 3;
        var steps = 10000;

        var moveProbability = 0.6;
        var toleranceRatio = 0.2;

        var minimumExpectedPosition = (int) ((steps * moveProbability) - (steps * toleranceRatio));
        var maximumExpectedPosition = (int) ((steps * moveProbability) + (steps * toleranceRatio));

        var race = new Race();
        race.resetWithCarsOf(numberOfCars);
        for (int i = 0; i<steps;++i) {
            race.progress();
        }

        for (var carPosition : race.getCarPositions()) {
            assertThat(carPosition)
                    .isGreaterThan(minimumExpectedPosition)
                    .isLessThan(maximumExpectedPosition);
        }
    }
}
