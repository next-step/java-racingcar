package study.step2;

import java.util.regex.Pattern;

public class Calculator {
    int calculator(String inputString) {

        if(inputString == null || inputString.equals("") || inputString.equals("null"))
            throw new IllegalArgumentException();

        String[] splitStrings = inputString.split(" ");

        if(splitStrings.length % 2 == 0)
            throw new IllegalArgumentException();

        String firstOperand = splitStrings[0];
        int result = 0;

        for (int i = 1; i + 1 < splitStrings.length; i = i + 2) {
            result = operation(firstOperand, splitStrings[i] , splitStrings[i + 1]);
            firstOperand = Integer.toString(result);
        }
        return result;
    }

    public int operation(String stringFirstOperand, String operator, String stringSecondOperand) {

        Pattern numberPattern = Pattern.compile("^[+-]?[0-9]+$");
        Pattern operatorPattern = Pattern.compile("[+\\-*/]");

        if(!numberPattern.matcher(stringFirstOperand).find() || !numberPattern.matcher(stringSecondOperand).find() || !operatorPattern.matcher(operator).find())
            throw new IllegalArgumentException();

        return OperatorEnum.getOperatorEnum(operator)
                           .operation(Integer.parseInt(stringFirstOperand), Integer.parseInt(stringSecondOperand));
    }
}

