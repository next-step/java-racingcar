package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private Calculator calculator;

    @Test
    void 나눗셈_0으로_나눌_때_애러() {
        calculator = new Calculator(
            new LinkedList(Arrays.asList("5", "0")),
            new LinkedList(Arrays.asList("/"))
        );

        assertThatIllegalArgumentException()
            .isThrownBy(() -> calculator.execute());
    }

    @Test
    void 나눗셈_결과가_소숫점_2자리가_맞는지_확인() {
        calculator = new Calculator(
            new LinkedList(Arrays.asList("1", "3")),
            new LinkedList(Arrays.asList("/"))
        );
        assertThat(hasTwoDecimalPoint(calculator.execute())).isTrue();
    }

    boolean hasTwoDecimalPoint(Double number) {
        double compare = number * Math.pow(10, 2);
        return compare == (int)compare;
    }

    @Test
    void 덧셈_정상() {
        calculator = new Calculator(
            new LinkedList(Arrays.asList("5", "2")),
            new LinkedList(Arrays.asList("+"))
        );
        assertThat(calculator.execute()).isEqualTo(7);
    }

    @Test
    void 뺼셈_정상() {
        calculator = new Calculator(
            new LinkedList(Arrays.asList("2", "5")),
            new LinkedList(Arrays.asList("-"))
        );
        assertThat(calculator.execute()).isEqualTo(-3);
    }

    @Test
    void 곱셈_정상() {
        calculator = new Calculator(
            new LinkedList(Arrays.asList("5", "2")),
            new LinkedList(Arrays.asList("*"))
        );
        assertThat(calculator.execute()).isEqualTo(10);
    }

    @Test
    void 연속연산_정상() {
        calculator = new Calculator(
            new LinkedList(Arrays.asList("12", "3", "4")),
            new LinkedList(Arrays.asList("+", "*"))
        );
        assertThat(calculator.execute()).isEqualTo(60);
    }
}
