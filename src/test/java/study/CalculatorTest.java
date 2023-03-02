package study;

import static org.assertj.core.api.Assertions.assertThatIOException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import calculator.Calculator;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

    @Test
    void testAssertThatThrownBy() {
        assertThatThrownBy(() -> {
            List<String> list = Arrays.asList("String one", "String two");
            list.get(2);
        }).isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("Index 2")
            .hasMessageContaining("length 2");
    }

    @Test
    void testAssertThatExceptionOfType() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                List<String> list = Arrays.asList("String one", "String two");
                list.get(2);
            }).withMessageMatching("Index \\d+.*length \\d+");
    }

//    @Test
//    void testAssertThatIOException() {
//        assertThatIOException().isThrownBy(() -> {
//            List<String> list = Arrays.asList("String one", "String two");
//            list.get(2);
//        }).isInstanceOf(IOException.class)
//            .hasMessageContaining("Index 2")
//            .hasMessageContaining("length 2");
//    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    void calculator(String input) {
        Calculator cal = new Calculator();
        cal.parser(input);
    }
}
