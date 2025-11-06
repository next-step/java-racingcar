package study.calculator;

import java.util.Arrays;

import static study.util.Parser.*;
import static study.util.StringParser.*;
import static study.util.Validate.*;

public class Token {

    private final String value;

    public Token(String input) {
        validateNullOrEmpty(input);
        this.value = input;
    }

    public int sum(){
        return sumCalculator(toPositiveIntArr(split(this.value)));
    }

    private int sumCalculator(int[] numbers){
        return Arrays.stream(numbers).sum();
    }

}
