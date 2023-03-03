package study;

import calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIOException;

public class calTest {

    public  static void main(String[] args) throws Exception {
        String result =  Calculator.excute("1 +2");
        System.out.println(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2", " 2 + 8 / 5 * 2 ", " 20 - 5 / 2 * 2 "})
    void caculator( String input) throws Exception {
        String result =  Calculator.excute(input);
        System.out.println(result);
    }

}
