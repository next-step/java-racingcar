package study;

import study.code.LiteralCodes;

public class StringCalculator {

    public double calculate(String input) throws Exception{
        if(isBlank(input)) throw new IllegalArgumentException();

        String[] arr = splitByWhiteSpace(input);
        double calculatedValue = calculateByOperator(arr);

        return calculatedValue;
    }

    private boolean isBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    private String[] splitByWhiteSpace(String input) {
        return input.split(LiteralCodes.L01);
    }

    private double calculateByOperator(String[] arr) throws Exception {
        double result = 0;

        for(int i = 1; i < arr.length - 1; i += 2) {
            Operator o = Operator.convertStringToOperator(arr[i]);
            double first = i == 1? Double.parseDouble(arr[i-1]) : result;
            double second = Double.parseDouble(arr[i+1]);

            result = o.operate(first, second);
        }
        return result;
    }


}
