package stringCalculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void initStringCalculatorTest(){
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @ValueSource(strings = "2000 + 21")
    @DisplayName("Adding Test")
    void adddingTest(String input){

    }

    @ParameterizedTest
    @ValueSource(strings = "2021 - 20")
    @DisplayName("Subtraction Test")
    void SubtractionTest(String input){

    }

    @ParameterizedTest
    @ValueSource(strings = "12 * 23")
    @DisplayName("Multiplication  Test")
    void multiplicationTest(String input){

    }

    @ParameterizedTest
    @ValueSource(strings = "2020 / 10")
    @DisplayName("division Test")
    void divisionTest(String input){

    }

    @ParameterizedTest
    @ValueSource(strings = "2 + 3 * 4 /")
    @DisplayName("Invalid parameter Test - wrong param")
    void invalidParamTest1(String input){

    }

    @ParameterizedTest
    @ValueSource(strings = "T E S + T")
    @DisplayName("Invalid parameter Test - not number")
    void invalidParamTest2(String input){

    }

    @ParameterizedTest
    @ValueSource(strings = "2 + 3 % 4 / 2")
    @DisplayName("Invalid parameter Test - not four rule calcultation")
    void invalidParamTest3(){

    }

    @Test
    @DisplayName("Invalid parameter Test - null or blank")
    void invalidParamTest4(){

    }

    @ParameterizedTest
    @ValueSource(strings = "2 + 3 * 4 / 2")
    @DisplayName("Valid parameter Test - wrong String")
    void validParamTest(String input){

    }



}