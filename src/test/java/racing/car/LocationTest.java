package racing.car;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LocationTest {
    @ValueSource(ints = {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 100000
    })
    @ParameterizedTest
    public void getValueTest(int value) {
        new Location(value).getValue();
    }

    @ValueSource(ints = {
            -1, -10, -100
    })
    @ParameterizedTest
    public void getValueIllegalArgumentExceptionTest(int value) {
        assertThatIllegalArgumentException().isThrownBy(() ->
            new Location(value).getValue()
        );
    }
}