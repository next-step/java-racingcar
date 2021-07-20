package calculator;

import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;

public class StringCalculator {

    public double calculate(String text) {
        if (text.equals(" ") || text.isEmpty()) {
            throw new EmptyExpressionException();
        }

        StringTokenizer stringTokenizer = new StringTokenizer(text);

        if (isPossibleToCalulateFirst(stringTokenizer)) {
            throw new WrongExpressionException();
        }

        double result = calculate(stringTokenizer);

        isNotInfinity(result);

        if (!stringTokenizer.hasMoreTokens()) {
            return result;
        }

        return nextCalculate(result, stringTokenizer);
    }

    private double calculate(StringTokenizer stringTokenizer) {
        return OperatorWith.of(getDoubleValue(stringTokenizer.nextToken()),
                getOperator(stringTokenizer.nextToken()),
                getDoubleValue(stringTokenizer.nextToken()))
                .calculate();
    }

    private double calculate(double result, StringTokenizer stringTokenizer) {
        return OperatorWith.of(result, getOperator(stringTokenizer.nextToken()), getDoubleValue(stringTokenizer.nextToken())).calculate();
    }

    private Operator getOperator(String operator) {
        return Operator.validOperator(operator);
    }

    private double getDoubleValue(String number) {
        try {
            return parseDouble(number);
        } catch (IllegalArgumentException e) {
            throw new WrongExpressionException();
        } catch (ArithmeticException e) {
            throw new NotDivideByZeroException();
        }
    }

    private void isNotInfinity(double result) {
        if (result == Double.POSITIVE_INFINITY) {
            throw new NotDivideByZeroException();
        }
    }

    private boolean isPossibleToCalulateFirst(StringTokenizer stringTokenizer) {
        return stringTokenizer.countTokens() <= 2;
    }

    private boolean isPossibleToCalulateNext(StringTokenizer stringTokenizer) {
        return stringTokenizer.countTokens() % 2 != 0;
    }

    private double nextCalculate(double result, StringTokenizer stringTokenizer) {
        if (isPossibleToCalulateNext(stringTokenizer)) {
            throw new WrongExpressionException();
        }

        while (stringTokenizer.hasMoreTokens()) {
            result = calculate(result, stringTokenizer);
        }
        isNotInfinity(result);
        return result;
    }

}
