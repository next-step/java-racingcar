package racing.car;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class FuelTest {
    @ValueSource(ints = {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9
    })
    @ParameterizedTest
    public void ctorTest(int fuelValue) {
        new Fuel(fuelValue);
    }

    @ValueSource(ints = {
            -1, -99, 10, 11, 15
    })
    @ParameterizedTest
    public void newIllegalArgumentExceptionTest(int fuelValue) {
        assertThatIllegalArgumentException()
                .isThrownBy(() ->
                    new Fuel(fuelValue));
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

    @ValueSource(ints = {
            10, 100, 1000, 10000
    })
    @ParameterizedTest
    public void randomInstanceTest(int testSize) {
        Fuel fuel = new RandomFuel();

        int movableCounter = 0;
        List<Boolean> valueList = new ArrayList<>();
        for (int i = 0; i < testSize; i++) {
            valueList.add(
                    fuel.isMovable(Car.REQUIRED_FUEL_VALUE));
        }
        assertThat(movableCounter)
                .withFailMessage("랜덤한 수가 나오지 않습니다.")
                .isNotEqualTo(testSize);
    }
}