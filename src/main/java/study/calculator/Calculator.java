package study.calculator;

public class Calculator {
    private static final String SPLIT_REGEX = " ";

    public String calculate(String input) {
        if(checkIfInputIsInvalid(input))
            throw new IllegalArgumentException();

        String[] inputArray = input.split(SPLIT_REGEX);

        if(checkIfInputArrayIsInvalid(inputArray))
            throw new IllegalArgumentException();

        String result = inputArray[0];

        for(int i=1; i<inputArray.length; i+=2)
            result = calculateInternal(result, Operator.find(inputArray[i]), inputArray[i+1]);

        return result;
    }

    private boolean checkIfInputIsInvalid(String input) {
        return input == null || input.equalsIgnoreCase("");
    }

    private boolean checkIfInputArrayIsInvalid(String[] inputArray) {
        return inputArray.length < 3 || inputArray.length % 2 != 1;
    }

    private String calculateInternal(String strNum1, Operator operator, String strNum2) {
        int num1 = Integer.parseInt(strNum1);
        int num2 = Integer.parseInt(strNum2);

        return operator.calculate(num1, num2).toString();
    }
}
