package second_calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class strCalculatorTest {
    private strCalculator cal = new strCalculator();

    @Test
    @DisplayName("덧셈테스트")
    void addTest() {
        assertThat(4).isEqualTo(cal.add(3,1));
    }

    @Test
    @DisplayName("뺄셈테스트")
    void substractTest() {
        assertThat(2).isEqualTo(cal.substract(3,1));
    }

    @Test
    @DisplayName("곱셈테스트")
    void multiplyTest() {
        assertThat(3).isEqualTo(cal.multiply(3,1));
    }

    @Test
    @DisplayName("나눗셈테스트")
    void divideTest() {
        assertThat(3).isEqualTo(cal.divide(3,1));
    }

    @ParameterizedTest
    @ValueSource(strings = {" "})
    @DisplayName("빈값테스트")
    void nullTest(String input) {
        assertThatThrownBy(()  -> {
            cal.isBlank(input);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("This value is not permitted");
    }

    @ParameterizedTest
    @ValueSource(strings = {"*","+","-","/","%","$"})
    @DisplayName("사칙연산기호여부테스트")
    void symbolTest(String input){
        assertThatThrownBy(()  -> {
            cal.isSymbol(input);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("This symbol is not permitted");
    }


    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    @DisplayName("사칙연산테스트")
    void calculatorTest(String input) {
        assertThat(cal.calculator(input)).isEqualTo(10);
    }
}
