package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class CalculatorTest {

    private CalculatorType cType;

    @Test
    void Add() {
        int result = cType.calculator("2 + 3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    void Minus() {
        int result = cType.calculator("3 - 2");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void Division() {
        int result = cType.calculator("10 / 5");
        assertThat(result).isEqualTo(2);
    }

    @Test
    void Multiplication() {
        int result = cType.calculator("2 * 3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void Arithmetic() {
        int result = cType.calculator("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }
}
