package calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

    @Before
    public void setUp() {
        System.out.println("setUp");
    }

    @Test
    public void 덧셈() {
        int result = Operator.ADD.calculate(1, 3);
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void 뺄셈() {
        int result = Operator.SUBTRACT.calculate(3, 1);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 곱셈() {
        int result = Operator.MULTIPLY.calculate(1, 3);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 나눗셈() {
        int result = Operator.DIVIDE.calculate(3, 1);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void test_looksOf() {
        // Given
        String anyLooks = "+";

        // When
        Operator operator = Operator.looksOf(anyLooks);

        // Then
        assertThat(operator).isEqualTo(Operator.ADD);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_looksOfException() {
        Operator.looksOf("&");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }

}