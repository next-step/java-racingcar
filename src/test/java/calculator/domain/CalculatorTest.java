package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

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

        Method subtract = Calculator.class.getDeclaredMethod("subtract", double.class, double.class);
        subtract.setAccessible(true);
        double result = (double) subtract.invoke(null, 3, 1);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void multiply()
            throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        Method multiply = Calculator.class.getDeclaredMethod("multiply", double.class, double.class);
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
        List<Double> terms = new ArrayList<>(Arrays.asList(1D, 2D, 3D, 10D, 2D, 2D));
        List<String> operators = new ArrayList<>(Arrays.asList("+", "+", "*", "-", "/"));

        // when
        double result = Calculator.evaluate(new Terms(terms), new Operators(operators));

        // then
        assertThat(result).isEqualTo(29L);
    }
}