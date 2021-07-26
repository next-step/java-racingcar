package stage2.stringcalculator;

import stage2.stringcalculator.exception.InvalidArithmeticOperatorException;

public class StringCalculator {

    public static int calculation(String inputString) {

        System.out.println("입력한 문자열 : " + inputString);

        String[] inputArray = inputString.split(" ");

        if ("".equals(inputArray[0]) || inputArray.length == 2) {
            throw new InvalidArithmeticOperatorException();
        }

        int calculationResult = calculator(getParseInt(inputArray[0]), inputArray[1], getParseInt(inputArray[2]));

        for (int i = 3; i < inputArray.length; i++) {
            calculationResult = calculator(calculationResult, inputArray[i], getParseInt(inputArray[i + 1]));
            i++;
        }

        return calculationResult;
    }

    private static int calculator(int before, String operatorSymbol, int after) {

        return ArithmeticOperation.arithmetic(operatorSymbol).calculation(before, after);
    }

    private static int getParseInt(String inputString) {

        return Integer.parseInt(inputString);
    }
}
