package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.model.Operator;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @DisplayName("add method test")
    @ParameterizedTest
    @CsvSource(value = {"1 + 1:2","100 + 100:200"},delimiter = ':')
    public void add(String str, int result ) {
    }


}
