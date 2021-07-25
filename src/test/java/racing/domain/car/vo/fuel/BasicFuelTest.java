package racing.domain.car.vo.fuel;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BasicFuelTest {
    @ValueSource(ints = {
            0, 9
    })
    @ParameterizedTest
    public void ctorTest(int fuelValue) {
        new BasicFuel(fuelValue);
    }

    @ValueSource(ints = {
            -1, -2, 10, 11
    })
    @ParameterizedTest
    public void ctorIllegalArgumentExceptionTest(int fuelValue) {
        assertThatIllegalArgumentException()
                .isThrownBy(() ->
                        new BasicFuel(fuelValue)
                );
    }
}