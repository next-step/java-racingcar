package step1;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator {

    public int doAddition(int leftOperand, int rightOperand) {
        return leftOperand + rightOperand;
    }

    public int doSubtraction(int leftOperand, int rightOperand) {
        return leftOperand - rightOperand;
    }

    public int doMultiplication(int leftOperand, int rightOperand) {
        return leftOperand * rightOperand;
    }

    public int doDivision(int leftOperand, int rightOperand) {
        if (leftOperand == 0 || rightOperand == 0) {
            return 0;
        }
        return leftOperand / rightOperand;
    }

    public int calculate(String parameter) {

        int result;

        String[] parsedParameter = parseParameter(parameter);

        assertValidParameter(parsedParameter);

        int i = 0;
        result = Integer.valueOf(parsedParameter[i]);

        while (i + 2 <= parsedParameter.length) {
            int variable = Integer.valueOf(parsedParameter[i + 2]);
            Character operator = parsedParameter[i + 1].charAt(0);

            switch (operator) {
                case Constants.ADDITION:
                    result = doAddition(result, variable);
                    break;
                case Constants.SUBTRACTION:
                    result = doSubtraction(result, variable);
                    break;
                case Constants.MULTIPLICATION:
                    result = doMultiplication(result, variable);
                    break;
                case Constants.DIVISION:
                    result = doDivision(result, variable);
                    break;
            }
            i += 2;
        }

        return result;
    }

    public Boolean assertValidParameter(String[] parsedParameter) {

        for (int i = 0; i < parsedParameter.length; ++i) {
            if (StringUtils.isBlank(parsedParameter[i])) {
                throw new IllegalArgumentException();
            }

            String current = parsedParameter[i];
            if ((i + 2) % 2 == 0 && (!StringUtils.isNumeric(current))) {
                throw new IllegalArgumentException();
            }

            if ((i + 2) % 2 == 1 && (!isValidFourArithmeticOperator(current))) {
                throw new IllegalArgumentException();
            }
        }

        return true;
    }

    public String[] parseParameter(String parameter) throws IllegalArgumentException {
        return parameter.split(Constants.WHITE_SPACE);
    }

    public Boolean isValidFourArithmeticOperator(String character) {

        Character operator = character.charAt(0);

        if (Character.isDigit(operator)) {
            return false;
        }

        switch (operator) {
            case Constants.ADDITION:
            case Constants.SUBTRACTION:
            case Constants.MULTIPLICATION:
            case Constants.DIVISION:
                return true;
        }

        return false;
    }
}