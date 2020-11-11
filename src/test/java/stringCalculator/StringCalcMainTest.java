package stringCalculator;

import org.junit.jupiter.api.Test;

import stringcalculator.StringCalcMain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class StringCalcMainTest {
    StringCalcMain stringCalc;
    
    @Test
    void validValueTest(){
        boolean result = stringCalc.validValue("2 + 3 * 4 / 2");
        assertTrue(result);
    }

    @Test
    void validValueTest_Exception(){
        assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> {
            boolean result = stringCalc.validValue("");
            assertFalse(result);
        }).withMessageMatching("Input is null or empty, Please check your input");
    }

}