package racing.domain.car.vo.fuel;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class RandomFuelTest {
    private static RandomFuel randomFuel;
    @BeforeAll
    public static void setUp() {
        randomFuel = new RandomFuel();
    }

    @ValueSource(ints = {
            10, 100, 1000, 10000
    })
    @ParameterizedTest
    public void randomFuelTest(int testSize) {
        Set<Integer> values = new HashSet<>();
        for (int i = 0; i < testSize; i++) {
            values.add(randomFuel.value());
        }
        assertThat(values.size())
                .withFailMessage("무조건 하나의 결과만 반환 됩니다.")
                .isNotEqualTo(1);
    }
}
