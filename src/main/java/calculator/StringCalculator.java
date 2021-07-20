package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StringCalculator {

    public static final String IS_NUMBER_REGEX = "[0-9]+";
    public static final String IS_OPERATION_REGEX = "[-+*/]";
    public static final String IS_NULL_ERROR_MESSAGE = "입력 값이 null이거나 빈 공백 문자입니다.";

    public int excute(String input) {
        validateInput(input.trim());
        String[] inputs = input.split(" ");
        List<Integer> numbers = parsingNumber(inputs);
        List<String> operations = parsingOperation(inputs);
        return input(numbers, operations);
    }

    private void validateInput(String input) throws IllegalArgumentException {
        if(Objects.isNull(input) || input.isEmpty()) {
            throw new IllegalArgumentException(IS_NULL_ERROR_MESSAGE);
        }
    }

    private List<Integer> parsingNumber(String[] inputs) {
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < inputs.length; i++) {
            isNumber(inputs[i], numbers);
        }
        return numbers;
    }

    private List<Integer> isNumber(String input, List<Integer> numbers) {
        if(input.matches(IS_NUMBER_REGEX)) {
            numbers.add(Integer.parseInt(input));
        }
        return numbers;
    }

    private List<String> parsingOperation(String[] inputs) {
        List<String> operations = new ArrayList<>();
        for(int i = 0; i < inputs.length; i++) {
            isOperation(inputs[i], operations);
        }
        return operations;
    }

    private List<String> isOperation(String input, List<String> operations) {
        if(input.matches(IS_OPERATION_REGEX)) {
            operations.add(input);
        }
        return operations;
    }

    private int input(List<Integer> numbers, List<String> operations) {
        int result = numbers.get(0);
        for(int i = 0; i < operations.size(); i++) {
            result = calculate(result, numbers.get(i+1), operations.get(i));
        }
        return result;
    }

    private int calculate(int oriNumber, int inputNumber, String operation) {
        int result = 0;

        if("+".equals(operation)) {
            result = oriNumber + inputNumber;
        }else if("-".equals(operation)) {
            result = oriNumber - inputNumber;
        }else if("*".equals(operation)) {
            result = oriNumber * inputNumber;
        }else if("/".equals(operation)) {
            result = oriNumber / inputNumber;
        }

        return result;
    }

}
