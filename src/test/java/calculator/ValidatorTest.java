package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidatorTest {

    private Validator validator;

    @BeforeEach
    void setUp(){
        this.validator = new Validator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1+ 2", "1 +2", " ", ""})
    public void isInputValidThrowsException(String input){
        assertThat(validator.isInputValid(input))
                .isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1+2", "1+2-3", "1+2-3*4", "1+2-3*4/5"})
    public void isInputValidReturnsTrue(String input){
        assertThat(validator.isInputValid(input))
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings={"1+ 2:false", "1 +2:false"})
    public void inputSplitByBlankThrowsException(String input){
        assertThat(validator.isSplitByBlank(input))
                .isTrue();
    }

    @Test
    public void inputIsBlankThrowsException(){
        assertThat(validator.isBlank(" "))
                .isTrue();
    }

    @Test
    public void inputIsNullThrowsException(){
        assertThat(validator.isNull(""))
                .isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,+,2:true",
            "1,+,2,-,3:true",
            "1,+,2,-,3,*,4:true",
            "1,+,2,-,3,*,4,/,5:true",
            "/,2:false",
            "1+-3:false"}, delimiter = ':')
    public void canValidateValidExpression(String input, boolean expected){
        List<String> inputList = Arrays.stream(
                input.split(","))
                .collect(Collectors.toList());
        assertEquals(validator.isCalculatable(inputList), expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1:true",
            "+:false",
            "23:true",
            ".:false"}, delimiter = ':')
    public void canValidateFirstCharacter(String input, boolean expected){
        assertEquals(validator.isCharacterNumber(input.charAt(0)), expected);
    }


    @ParameterizedTest
    @CsvSource(value = {
            "12:true",
            "1:true",
            "+:false",
            "*4:false",
            "1*/:false"}, delimiter = ':')
    public void canValidateNumber(String input, boolean expected){
        assertEquals(validator.isNumber(input),expected);
    }
}