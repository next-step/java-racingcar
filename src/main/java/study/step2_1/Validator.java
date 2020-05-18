package study.step2_1;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class Validator {

    private final static String NUMBERPATTERN = "^[0-9]+$";
    private final static int NUMBER_ONE = 1;
    private final static int NUMBER_TWO = 2;
    private final static Pattern PATTERN_COMPILE = Pattern.compile(NUMBERPATTERN);
    private String [] inputValues;

    public Validator(String [] inputValues) {
        this.inputValues = inputValues;
    }

    public static boolean isBlank(String input){
        if (Objects.isNull(input)  || input.trim().isEmpty()){
            throw new IllegalArgumentException("값이 비어있습니다.");
        }
        return false;
    }

    public static boolean isNumber(String value) {
        if (!isBlank(value)){
            return PATTERN_COMPILE.matcher(value).find();
        }
        return false;
    }

    public List<String> validateOperator(List<String> separateOperator) {
        if (isNaturalOperator(separateOperator)){
            return separateOperator;
        }
        throw new IllegalArgumentException();
    }

    public List<Double> validateNumbers(List<Double> numbers) {
        if (isNaturalNumber(numbers)){
            return numbers;
        }
        throw new IllegalArgumentException();
    }

    private boolean isNaturalOperator(List<String> separateOperator) {
        return !Objects.isNull(separateOperator) && (inputValues.length - NUMBER_ONE) / NUMBER_TWO == separateOperator.size();
    }

    private boolean isNaturalNumber(List<Double> numbers) {
        return !Objects.isNull(numbers) && (inputValues.length + NUMBER_ONE) / NUMBER_TWO == numbers.size();
    }
}