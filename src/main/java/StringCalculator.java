public class StringCalculator {
    private static final String SEPARATOR = " ";

    public static int calculate(String expression) throws RuntimeException {
        int calculateResult = 0;

        String[] calArr = inputData(expression);
        calculateResult = Integer.parseInt(calArr[0]);

        for (int i = 1; i < calArr.length; i += 2) {
            String operator = calArr[i];
            int operand = Integer.parseInt(calArr[i + 1]);

            calculateResult = eachOperation(calculateResult, operator, operand);
        }

        return calculateResult;
    }

    private static int eachOperation(int calculateResult, String operator, int operand) throws RuntimeException {
        switch (operator) {
            case "+":
                calculateResult += operand;
                break;
            case "-":
                calculateResult -= operand;
                break;
            case "*":
                calculateResult *= operand;
                break;
            case "/":
                calculateResult /= operand;
                break;
            default:
                throw new RuntimeException();
        }
        return calculateResult;
    }

    private static String[] inputData(String expression) {
        return split(expression);
    }

    private static String[] split(String value) {
        return value.split(SEPARATOR);
    }

}
