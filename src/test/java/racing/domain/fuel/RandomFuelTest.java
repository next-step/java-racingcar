package racing.domain.fuel;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class RandomFuelTest {
    @ValueSource(ints = {
            10, 100, 1000, 10000
    })
    @ParameterizedTest
    public void randomFuelTest(int testSize) {
        Fuel fuel = RandomFuel.getInstance();

        Set<Integer> values = new HashSet<>();
        for (int i = 0; i < testSize; i++) {
            values.add(fuel.value());
        }
        assertThat(values.size())
                .withFailMessage("무조건 하나의 결과만 반환 됩니다.")
                .isNotEqualTo(1);
    }
}
