package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
    private List<String> formula = new ArrayList<>();

    @DisplayName("입력값을 받아서 더할 수 있다.")
    @Test
    void addTest() {
        formula.add("2");
        formula.add("+");
        formula.add("3");
        assertThat(5).isEqualTo(Operator.findSymbol(formula.get(1))
                .calculate(Integer.parseInt(formula.get(0)), Integer.parseInt(formula.get(2))));
    }

    @DisplayName("입력값을 받아서 뺄수 있다.")
    @Test
    void subtractTest() {
        formula.add("8");
        formula.add("-");
        formula.add("3");
        assertThat(5).isEqualTo(Operator.findSymbol(formula.get(1))
                .calculate(Integer.parseInt(formula.get(0)), Integer.parseInt(formula.get(2))));
    }

    @DisplayName("입력값을 받아서 곱할수 있다.")
    @Test
    void multiplyTest() {
        formula.add("2");
        formula.add("*");
        formula.add("3");
        assertThat(6).isEqualTo(Operator.findSymbol(formula.get(1))
                .calculate(Integer.parseInt(formula.get(0)), Integer.parseInt(formula.get(2))));
    }

    @DisplayName("입력값을 받아서 나눌수 있다.")
    @Test
    void divideTest() {
        formula.add("6");
        formula.add("/");
        formula.add("3");
        assertThat(2).isEqualTo(Operator.findSymbol(formula.get(1))
                .calculate(Integer.parseInt(formula.get(0)), Integer.parseInt(formula.get(2))));
    }
}
