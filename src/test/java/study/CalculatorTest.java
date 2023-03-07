package study;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    void substring(){
        final String actual = "2+3*2";
        Stack<Double> actual2 = new Stack<>();


        assertThat(actual).isEqualTo("1,2");
    }

}
