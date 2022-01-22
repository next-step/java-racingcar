package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class OperatorsTest {

    @Test
    void 연산자_리스트를_받아_생성() {
        List<String> ops = new ArrayList<>(Arrays.asList("+", "-"));

        Operators operators = new Operators(ops);

        assertThat(operators.getOperators().size()).isEqualTo(2);
    }

    @Test
    void nextOperator() {
        List<String> ops = new ArrayList<>(Arrays.asList("+", "-"));
        Operators operators = new Operators(ops);

        assertThat(operators.nextOperator()).isEqualTo("+");
        assertThat(operators.nextOperator()).isEqualTo("-");
    }
}