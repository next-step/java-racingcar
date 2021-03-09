package stringcalculator;

public class StringCalculator {

    private final static int START_INDEX = 1;
    private final static int INTERVAL_INDEX = 2;
    private final static int LEFT_INDEX = -1;
    private final static int RIGHT_INDEX = 1;

    public static double runCalculator(String inputExpression) {
        String[] parsedExpression = StringParser.parseInput(inputExpression);
        int result = calculateExpression(parsedExpression);
        System.out.println("결과값: " + result);
        return result;
    }

    private static int calculateExpression(String[] parsedExpression) {
        double leftNumber = StringParser.of(parsedExpression[START_INDEX + LEFT_INDEX]);
        for (int idx = START_INDEX; idx < parsedExpression.length; idx += INTERVAL_INDEX) {
            Operation operation = Operation.of(parsedExpression[idx]);
            double rightNumber = StringParser.of(parsedExpression[idx + RIGHT_INDEX]);
            leftNumber = operation.operate(leftNumber, rightNumber);
        }
        return (int) leftNumber;
    }
}
