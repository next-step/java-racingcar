package racing.car;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class FuelTest {
    @ValueSource(ints = {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9
    })
    @ParameterizedTest
    public void isMovableTest(int fuelValue) {
        new Fuel(fuelValue).isMovable(Car.REQUIRED_FUEL_VALUE);
    }

    @ValueSource(ints = {
            -1, -99, 10, 11, 15
    })
    @ParameterizedTest
    public void isMovableIllegalArgumentExceptionTest(int fuelValue) {
        assertThatIllegalArgumentException()
                .isThrownBy(() ->
                    new Fuel(fuelValue).isMovable(Car.REQUIRED_FUEL_VALUE));
    }

    @Test
    public void emptyTest() {
        assertThat(Fuel.EMPTY.isMovable(Car.REQUIRED_FUEL_VALUE))
                .isEqualTo(false);
    }

    @Test
    public void fullTest() {
        assertThat(Fuel.FULL.isMovable(Car.REQUIRED_FUEL_VALUE))
                .isEqualTo(true);
    }
}