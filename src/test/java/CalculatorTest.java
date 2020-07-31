import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    private ArithmeticArguments args;

    @BeforeEach
    void setUp() {
        this.args = new ArithmeticArguments("2 + 3 * 4 / 2");
    }


    @Test
    void calculateTest() {
        assertThat(Calculator.calculate(args)).isEqualTo(10);
    }
}