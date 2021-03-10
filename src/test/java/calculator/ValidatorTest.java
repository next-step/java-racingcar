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
        assertThat(validator.isInputBlankSafe(input))
                .isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1+2", "1+2-3", "1+2-3*4", "1+2-3*4/5"})
    public void isInputValidReturnsTrue(String input){
        assertThat(validator.isInputBlankSafe(input))
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
            "2/:false",
            "1+-3:false",
            "1&3:false",
            "@:false"}, delimiter = ':')
    public void canValidateCalculatableExpression(String input, boolean expected){
        List<String> inputList = Arrays.stream(
                input.split(","))
                .collect(Collectors.toList());
        assertEquals(validator.isCalculatable(inputList), expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "true:1:true",
            "true:-:false",
            "false:-:true",
            "false:2:false"}, delimiter = ':')
    public void canValidateValidExpression(boolean numberFlag, String input, boolean expected){
        assertEquals(validator.isValidExpression(numberFlag, input), expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "+:true",
            "-:true",
            "*:true",
            "/:true",
            "1+:false",
            "/1:false",
            ".:false",
            "=:false"}, delimiter = ':')
    public void canValidateOperator(String input, boolean expected){
        assertEquals(validator.isOperator(input),expected);
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