package calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeparatorTest {

    Separator separator = new Separator("1 + 2 - 3 * 4 / 5");


    @Test
    void isIntegerSuccessTest() {
        String[] actual = { "1", "2", "3" };

        Arrays.stream(actual).forEach(act -> assertThat(separator.isInteger(act)).isEqualTo(true));
    }

    @Test
    void isIntegerFailTest() {
        String[] actual = { "-", "+"};

        Arrays.stream(actual).forEach(act -> assertThat(separator.isInteger(act)).isEqualTo(false));
    }

    @Test
    void isOperatorSucessTest() {
        String[] actual = { "+", "-", "*" };

        Arrays.stream(actual).forEach(act -> assertThat(separator.isOperator(act)).isEqualTo(true));

    }

    @Test
    void isOperatorFailTest() {
        String[] actual = { "1", "2", "3" };

        Arrays.stream(actual).forEach(act -> assertThat(separator.isOperator(act)).isEqualTo(false));

    }

    @Test
    void getNumberTest() {
        List<Integer> actual = separator.getNumbers();
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getOperatorTest() {
        List<Operator> actual = separator.getOperators();
        List<Operator> expected = new ArrayList<>(Arrays.asList(Operator.PLUS, Operator.MINUS, Operator.MULTIPLY, Operator.DIVIDE));

        assertThat(actual).isEqualTo(expected);
    }
}
