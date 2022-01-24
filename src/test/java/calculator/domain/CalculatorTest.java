package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void add() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method add = Calculator.class.getDeclaredMethod("add", double.class, double.class);
        add.setAccessible(true);
        double result = (double) add.invoke(null, 1, 3);

        assertThat(result).isEqualTo(4);
    }

    @Test
    void subtract()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method subtract = Calculator.class.getDeclaredMethod("subtract", double.class,
                double.class);
        subtract.setAccessible(true);
        double result = (double) subtract.invoke(null, 3, 1);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void multiply()
            throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        Method multiply = Calculator.class.getDeclaredMethod("multiply", double.class,
                double.class);
        multiply.setAccessible(true);
        double result = (double) multiply.invoke(null, 2, 3);

        assertThat(result).isEqualTo(6);
    }

    @Test
    void divide() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method divide = Calculator.class.getDeclaredMethod("divide", double.class, double.class);
        divide.setAccessible(true);
        double result = (double) divide.invoke(null, 4, 2);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void evaluate() {

        // given
        ArrayList<Double> values = new ArrayList<>(Arrays.asList(1D, 2D, 3D, 10D, 2D, 2D));
        Terms terms = new Terms();
        terms.addTermAll(values);

        List<String> ops = new ArrayList<>(Arrays.asList("+", "+", "*", "-", "/"));
        Operators operators = new Operators();
        operators.addOperatorAll(ops);

        // when
        double result = Calculator.evaluate(terms, operators);

        // then
        assertThat(result).isEqualTo(29L);
    }

    @Test
    void divide_0으로_나눔() {

        // given
        ArrayList<Double> values = new ArrayList<>(Arrays.asList(1D, 0D));
        Terms terms = new Terms();
        terms.addTermAll(values);

        List<String> ops = new ArrayList<>(Arrays.asList("/"));
        Operators operators = new Operators();
        operators.addOperatorAll(ops);

        assertThrows(ArithmeticException.class, () -> Calculator.evaluate(terms, operators));
    }
}