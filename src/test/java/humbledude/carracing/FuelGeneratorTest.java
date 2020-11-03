package humbledude.carracing;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class FuelGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void constantFuelGenerator(int source) {
        FuelGenerator constantFuelGenerator = new ConstantFuelGenerator(source);

        int fuel = constantFuelGenerator.generate();

        assertThat(fuel).isEqualTo(source);
    }

    @RepeatedTest(100)
    public void randomFuelGenerator() {
        FuelGenerator randomFuelGenerator = new RandomFuelGenerator();

        int fuel = randomFuelGenerator.generate();

        assertThat(fuel).isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }
}
