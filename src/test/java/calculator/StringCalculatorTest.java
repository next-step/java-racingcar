package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @Test
    void add(){
        int result = StringCalculator.add(1,2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void sub(){
        int result = StringCalculator.sub(3,1);
        assertThat(result).isEqualTo(2);
    }
}
