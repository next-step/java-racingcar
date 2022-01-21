package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

    @Test
    void add() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method add = Calculator.class.getDeclaredMethod("add", long.class, long.class);
        add.setAccessible(true);
        long result = (long) add.invoke(null, 1, 3);

        assertThat(result).isEqualTo(4);
    }

    @Test
    void subtract()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method subtract = Calculator.class.getDeclaredMethod("subtract", long.class, long.class);
        subtract.setAccessible(true);
        long result = (long) subtract.invoke(null, 3, 1);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void multiply()
            throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        Method multiply = Calculator.class.getDeclaredMethod("multiply", long.class, long.class);
        multiply.setAccessible(true);
        long result = (long) multiply.invoke(null, 2, 3);

        assertThat(result).isEqualTo(6);
    }

    @Test
    void divide() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method divide = Calculator.class.getDeclaredMethod("divide", long.class, long.class);
        divide.setAccessible(true);
        long result = (long) divide.invoke(null, 4, 2);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void evaluate() {

        // given
        List<Long> terms = new ArrayList<>(Arrays.asList(1L, 2L, 3L, 10L, 2L, 2L));
        List<String> operators = new ArrayList<>(Arrays.asList("+", "+", "*", "-", "/"));
        Expression expression = new Expression(terms, operators);

        // when
        long result = Calculator.evaluate(expression);

        // then
        assertThat(result).isEqualTo(29L);
    }
}