import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    void splitString() {
        String[] value = "1 + 2".split(" ");
        assertThat(value).contains("+");
        //Arrays.stream(value).forEach(System.out::println);
    }

    @Test
    void addOperationTest() {
        String[] value = "1 + 2".split(" ");
        assertThat(calc.add(value[0], value[2])).isEqualTo(3);
    }

    @Test
    void subOperationTest() {
        String[] value = "1 - 2".split(" ");
        assertThat(calc.sub(value[0], value[2])).isEqualTo(-1);
    }

    @Test
    void multiplicationOperationTest() {
        String[] value = "5 * 7".split(" ");
        assertThat(calc.multiply(value[0], value[2])).isEqualTo(35);
    }

    @Test
    void divideOperationTest() {
        String[] value = "32 * 8".split(" ");
        assertThat(calc.divide(value[0], value[2])).isEqualTo(4);
    }
}