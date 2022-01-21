package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void add() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method add = Calculator.class.getDeclaredMethod("add", long.class, long.class);
        add.setAccessible(true);
        long result = (long)add.invoke(null,1,3);

        assertThat(result).isEqualTo(4);
    }

    @Test
    void subtract() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method subtract = Calculator.class.getDeclaredMethod("subtract", long.class, long.class);
        subtract.setAccessible(true);
        long result = (long)subtract.invoke(new Calculator(), 3,1);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void multiply() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        Method multiply = Calculator.class.getDeclaredMethod("multiply", long.class, long.class);
        multiply.setAccessible(true);
        long result = (long)multiply.invoke(new Calculator(), 2,3);

        assertThat(result).isEqualTo(6);
    }

    @Test
    void divide() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method divide = Calculator.class.getDeclaredMethod("divide", long.class, long.class);
        divide.setAccessible(true);
        long result = (long)divide.invoke(new Calculator(), 4,2);

        assertThat(result).isEqualTo(2);
    }

}