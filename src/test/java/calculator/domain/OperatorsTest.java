package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperatorsTest {

    Operators operators;

    @BeforeEach
    void before() {
        operators = new Operators();

        operators.addOperator("+");
        operators.addOperator("-");
    }

    @Test
    void 생성_테스트() {
        assertNotNull(operators.getOperators());
    }

    @Test
    void addOperator() {
        assertThat(operators.getOperators().size()).isEqualTo(2);
    }

    @Test
    void nextOperator() {
        assertThat(operators.nextOperator()).isEqualTo("+");
        assertThat(operators.nextOperator()).isEqualTo("-");
    }

    @Test
    void hasNext_true() {
        assertTrue(operators.hasNext());
    }

    @Test
    void hasNext_false() {
        operators.nextOperator();
        operators.nextOperator();

        assertFalse(operators.hasNext());
    }
}