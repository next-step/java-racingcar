package calculator;

import java.util.Arrays;

public class StringCalculator {
    final static String SEPARATOR = " "; //입력되는 inputData Seperator
    final static int CALCULATE_COUNT = 2; //계산하는 대상 갯수 현재 계산기는 2개만 계산 될 수 있다.
    final static int MIN_CALCULATE_LENGTH = 3;

    public StringCalculator(){
        super();
    }

    public double calculate(String inputData) {
        if (inputData == null || inputData.isEmpty()) {
            throw new IllegalArgumentException("input data is invalid");
        }

        String[] inputArray = inputData.split(SEPARATOR);

        if (isInValidLength(inputArray)) {
            throw new IllegalArgumentException("input data is invalid");
        }

        double result = calculate(inputArray);

        return result;
    }

    public double calculate(String[] inputArray) {
        if (isInValidLength(inputArray)) {
            return Double.parseDouble(inputArray[0]);
        }

        Operator operator= Operator.find(inputArray[CALCULATE_COUNT-1]);

        try {
            double result = operator.calculate(Double.parseDouble(inputArray[CALCULATE_COUNT-2]), Double.parseDouble(inputArray[CALCULATE_COUNT]));
            inputArray[CALCULATE_COUNT] = Double.toString(result);
            String[] _inputArray = Arrays.copyOfRange(inputArray, CALCULATE_COUNT, inputArray.length);
            return calculate(_inputArray);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException("operand is must double");
        }
    }
    public boolean isInValidLength(String[] array) {
        return array.length < MIN_CALCULATE_LENGTH ? true : false;
    }
}
