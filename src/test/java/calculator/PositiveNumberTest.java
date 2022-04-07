package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PositiveNumberTest {

    private PositiveNumber positiveNumber1;
    private PositiveNumber positiveNumber2;

    @BeforeEach
    void setUp(){
        positiveNumber1 = new PositiveNumber(1);
        positiveNumber2 = new PositiveNumber("2");
    }

    @Test
    void getValue(){
        assertThat(positiveNumber1.getValue()).isEqualTo(1);
        assertThat(positiveNumber2.getValue()).isEqualTo(2);
    }
}