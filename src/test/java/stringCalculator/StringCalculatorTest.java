package stringCalculator;

import org.junit.jupiter.api.Test;

import stringcalculator.StringCalculator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    String value = "2 + 3 * 4 / 2";

    @Test
    void calculatorTest(){
        int result = stringCalculator.calculator(value);
        assertThat(result).isEqualTo(10);
    }

    @Test
    void sortByNumAndSymbolTest(){
        assertTrue(stringCalculator.sortByNumAndSymbol(value));
    }

    @Test
    void symbolSelector_plus(){
        int result = stringCalculator.symbolSelector(1,1,"+");
        assertThat(result).isEqualTo(2);
    }

    @Test
    void symbolSelector_minus(){
        int result = stringCalculator.symbolSelector(1,1,"-");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void symbolSelector_mulitiply(){
        int result = stringCalculator.symbolSelector(2,1,"*");
        assertThat(result).isEqualTo(2);
    }

    @Test
    void symbolSelector_divide(){
        int result = stringCalculator.symbolSelector(4,2,"/");
        assertThat(result).isEqualTo(2);
    }

    @Test
    void symbolSelector_Exception(){
        assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> {
            stringCalculator.symbolSelector(1,1,";");
        }).withMessageMatching("Incorrect symbol, Please check your symbol");
    }

    @Test
    void addTest(){
        int result = stringCalculator.add(1,1);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void subTest(){
        int result = stringCalculator.sub(1,1);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void multipleTest(){
        int result = stringCalculator.multiple(2,1);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void divTest(){
        int result = stringCalculator.div(4,2);
        assertThat(result).isEqualTo(2);
    }

}