import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    @ParameterizedTest
    @CsvSource(value = {"4:1", "3:0"}, delimiter = ':')
    void advanceCars(int input, int result) {
        GameCondition condition = () -> input;
        Cars cars = CarFactory.generateCars(1);
        cars.setMoveStrategy(condition);
        cars.advanceCars();

        assertThat(cars.getCars()
                .get(0)
                .getNumberOfAdvance())
                .isEqualTo(result);
    }
}