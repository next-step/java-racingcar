package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

public class NumberTest {
    @Test
    @DisplayName("정수 체크")
    void numberTest() {
        CalculateNumber no1 = new CalculateNumber(1);
        CalculateNumber no2 = new CalculateNumber(1);
        CalculateNumber no3 = new CalculateNumber(1);
        CalculateNumber no4 = new CalculateNumber(1);
        CalculateNumber no5 = new CalculateNumber(1);
        //CalculateNumber no6 = new CalculateNumber(0.1);
    }

}
