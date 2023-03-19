package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OperationTest {

    @DisplayName("사칙연산 + 조회")
    @Test
    void findAddition() {
        String symbol = "+";
        Operation actual = Operation.findBySymbol(symbol);
        assertThat(actual).isEqualTo(Operation.ADD);
    }

    @DisplayName("사칙연산 - 조회")
    @Test
    void findMiunus() {
        String symbol = "-";
        Operation actual = Operation.findBySymbol(symbol);
        assertThat(actual).isEqualTo(Operation.MIN);
    }

    @DisplayName("사칙연산 * 조회")
    @Test
    void findMultiply() {
        String symbol = "*";
        Operation actual = Operation.findBySymbol(symbol);
        assertThat(actual).isEqualTo(Operation.MUL);
    }

    @DisplayName("사칙연산 / 조회")
    @Test
    void findDivision() {
        String symbol = "/";
        Operation actual = Operation.findBySymbol(symbol);
        assertThat(actual).isEqualTo(Operation.DIV);
    }

    @DisplayName("사칙연산자 이외의 연산자 조회")
    @ParameterizedTest
    @ValueSource(strings = {"^", "=", "%"})
    void invalidSymbolFind(String symbol) {
        assertThrows(IllegalArgumentException.class, () ->{
           Operation.findBySymbol(symbol);
        });
    }

}