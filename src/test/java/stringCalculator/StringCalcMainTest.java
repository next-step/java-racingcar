package stringCalculator;

import org.junit.jupiter.api.Test;

import stringcalculator.StringCalcMain;

import static org.assertj.core.api.Assertions.*;


public class StringCalcMainTest {
    StringCalcMain stringCalc;
    
    @Test
    void validValueTest_Exception(){
        assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> {
            stringCalc.validateValue("");
        }).withMessageMatching("Input is null or empty, Please check your input");
    }

}