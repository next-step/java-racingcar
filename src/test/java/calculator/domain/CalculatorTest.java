package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private Calculator cal;

    @BeforeEach
    void before() {
        cal = new Calculator();
    }
    
    @Test
    void setBeforeNum() {
        cal.setBeforeNum(5);
        Assertions.assertThat(cal.getBeforeNum()).isEqualTo(5);
    }

    @Test
    void setNextNum() {
        cal.setNextNum(11);
        Assertions.assertThat(cal.getNextNum()).isEqualTo(11);
    }

    @Test
    void validOperatorDiv() {
        Assertions.assertThatThrownBy(() -> {
            cal.validOperatorDiv("&");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void calculate() {
        cal.setBeforeNum(5);
        cal.setNextNum(11);
        Assertions.assertThat(cal.calculate("+")).isEqualTo(16);

    }
}