import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRacingTest {

    @Test
    void carRacingMoveFailedTest() {
        assertThatThrownBy(() -> new CarRacing(5, 0).moveAllCar())
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("out of move count");
    }

    @Test
    void moveAllCarsTest() {
        int expected = 1;

        CarRacing carRacing = new CarRacing(5, 2);
        carRacing.moveAllCar();

        assertThat(carRacing.remainMoveCount).isEqualTo(expected);
    }
}
