package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @Test
    void plus() throws Exception {
        assertThat(calculator.solve("5 + 8"))
                .isEqualTo(13);
    }


    @Test
    void minus() throws Exception {
        assertThat(calculator.solve("5 - 8"))
                .isEqualTo(-3);
    }


    @Test
    void multiply() throws Exception {
        assertThat(calculator.solve("5 * 8"))
                .isEqualTo(40);
    }


    @Test
    void divide() throws Exception {
        assertThat(calculator.solve("5 / 8"))
                .isEqualTo(0.625);
    }
}
