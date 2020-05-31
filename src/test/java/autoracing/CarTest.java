package autoracing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3, 8, 10, 100})
    public void hasHistorySameAmountAsRounds(int rounds) {
        Car car = new Car();
        for (int i = 0; i < rounds; i++) {
            car.race();
        }
        assertThat(car.getHistory().size()).isEqualTo(rounds);
    }
}
