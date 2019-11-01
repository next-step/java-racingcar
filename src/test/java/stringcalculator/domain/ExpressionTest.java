package stringcalculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionTest {

    @Test
    void add_피연산자_연산자_덧셈() {
        Expression expression = new Expression();
        expression.add("1");
        expression.add("+");
        expression.add("1");
        assertThat(expression.operate()).isEqualTo(2);
    }

    @Test
    void add_피연산자_연산자_뺄셈() {
        Expression expression = new Expression();
        expression.add("1");
        expression.add("-");
        expression.add("1");
        assertThat(expression.operate()).isEqualTo(0);
    }

    @Test
    void add_피연산자_연산자_곱셈() {
        Expression expression = new Expression();
        expression.add("2");
        expression.add("*");
        expression.add("3");
        assertThat(expression.operate()).isEqualTo(6);
    }

    @Test
    void add_피연산자_연산자_나눗셈() {
        Expression expression = new Expression();
        expression.add("6");
        expression.add("/");
        expression.add("3");
        assertThat(expression.operate()).isEqualTo(2);
    }

    @Test
    void add_피연산자_연산자_복합식() {
        Expression expression = new Expression();
        expression.add("6");
        expression.add("/");
        expression.add("3");
        expression.add("*");
        expression.add("4");
        expression.add("-");
        expression.add("4");
        expression.add("+");
        expression.add("1");
        assertThat(expression.operate()).isEqualTo(5);
    }
}
