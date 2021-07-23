package racing.car;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomFuelTest {
    @ValueSource(ints = {
            10, 100, 1000, 10000
    })
    @ParameterizedTest
    public void randomFuelTest(int testSize) {
        Fuel fuel = new RandomFuel();

        int movableCounter = 0;
        for (int i = 0; i < testSize; i++) {
            if (fuel.isMovable(Car.REQUIRED_FUEL_VALUE))
                movableCounter++;
        }
        assertThat(movableCounter)
                .withFailMessage("무조건 Not Movable 입니다.")
                .isNotEqualTo(0);
        assertThat(movableCounter)
                .withFailMessage("무조건 Movable 입니다.")
                .isNotEqualTo(testSize);
    }
}
