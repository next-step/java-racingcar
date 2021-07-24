package racing.domain.fuel;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class FuelTest {
    @ValueSource(ints = {
            0, 9
    })
    @ParameterizedTest
    public void ctorTest(int fuelValue) {
        new Fuel(fuelValue);
    }

    @ValueSource(ints = {
            -1, -2, 10, 11
    })
    @ParameterizedTest
    public void ctorIllegalArgumentExceptionTest(int fuelValue) {
        assertThatIllegalArgumentException()
                .isThrownBy(() ->
                        new Fuel(fuelValue)
                );
    }
}