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
    public void newTest(int fuelValue) {
        Fuel.newInstance(fuelValue);
    }

    @ValueSource(ints = {
            -1, -99, 10, 11, 15
    })
    @ParameterizedTest
    public void newIllegalArgumentExceptionTest(int fuelValue) {
        assertThatIllegalArgumentException()
                .isThrownBy(() ->
                    Fuel.newInstance(fuelValue));
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

    @Test
    public void randomTest() {
        boolean movable = false;
        for (int i = 0; i < Integer.MAX_VALUE && !movable; i++) {
            movable = Fuel.randomInstance().isMovable(
                    Car.REQUIRED_FUEL_VALUE
            );
        }
        assertThat(movable)
                .isEqualTo(true);
    }
}