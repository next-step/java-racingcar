import model.Car;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void carMovesWithProbability() {
        var moveProbability = 0.6;

        var steps = 100000;
        var toleranceRatio = 0.1;

        var car = new Car();
        for (int i = 0; i < steps; ++i) {
            car.attemptMove();
        }

        var minimumExpectedPosition = (int) ((steps * moveProbability) - (steps * toleranceRatio));
        var maximumExpectedPosition = (int) ((steps * moveProbability) + (steps * toleranceRatio));

        assertThat(car.getPosition())
                .isGreaterThan(minimumExpectedPosition)
                .isLessThan(maximumExpectedPosition);
    }
}
