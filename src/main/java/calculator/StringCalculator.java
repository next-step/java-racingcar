package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public static final String IS_NUMBER_REGEX = "[0-9]+";
    public static final String IS_OPERATION_REGEX = "[-+*/]";

    public int excute(String input) {
        String[] inputs = input.split(" ");
        List<Integer> numbers = parsingNumber(inputs);
        List<String> operations = parsingOperation(inputs);
        return calculate(numbers, operations);
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

    private int calculate(List<Integer> numbers, List<String> operations) {
        int result = numbers.get(0);
        for(int i = 0; i < operations.size(); i++) {
            result = input(result, numbers.get(i+1), operations.get(i));
        }
        return result;
    }

    private int input(int oriNumber, int inputNumber, String operation) {
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
