package step1;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator {

    private int doAddition(int first, int second) {
        return first + second;
    }

    private int doSubtraction(int first, int second) {
        return first - second;
    }

    private int doMultiplication(int first, int second) {
        return first * second;
    }

    private int doDivision(int first, int second) {
        return first / second;
    }

    public int calculate(String parameter) {

        int result;

        String[] parsedParameter = parseParameter(parameter);

        assertValidParameter(parsedParameter);

        int i = 0;
        result = Integer.valueOf(parsedParameter[i]);

        while (i+2 <= parsedParameter.length) {
            int variable = Integer.valueOf(parsedParameter[i+2]);
            Character operator = parsedParameter[i+1].charAt(0);

            switch (operator) {
                case '+' :
                    result = doAddition(result, variable);
                    break;
                case '-' :
                    result = doSubtraction(result, variable);
                    break;
                case '*' :
                    result = doMultiplication(result, variable);
                    break;
                case '/' :
                    result = doDivision(result, variable);
                    break;
            }
            i+=2;
        }

        return result;
    }

    public Boolean assertValidParameter(String[] parsedParameter) {

        for (int i = 0; i < parsedParameter.length; ++i) {
            if (StringUtils.isBlank(parsedParameter[i])) {
                throw new IllegalArgumentException();
            }

            String current = parsedParameter[i];
            if ((i+2)%2 == 0 && (!StringUtils.isNumeric(current))) {
                throw new IllegalArgumentException();
            }

            if ((i+2)%2 == 1 && (!isValidFourArithmeticOperator(current))) {
                throw new IllegalArgumentException();
            }
        }

        return true;
    }

    public String[] parseParameter(String parameter) throws IllegalArgumentException {
        return parameter.split(" ");
    }

    public Boolean isValidFourArithmeticOperator(String character) {

        Character operator = character.charAt(0);

        if (Character.isDigit(operator)) {
            return false;
        }

        switch (operator) {
            case '+' :
            case '-' :
            case '*' :
            case '/' :
                    return true;
        }

        return false;
    }
}