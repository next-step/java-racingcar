import java.util.Scanner;

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

    private static int eachOperation(int calculateResult, String operator, int operand) {
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
//                throw new RuntimeException();
        }
        return calculateResult;
    }

    private static String[] inputData(String expression) {
//        System.out.print("연산할 식을 입력하세요. >> ");
//        Scanner scanner = new Scanner(System.in);
//        String value = scanner.nextLine();
        return split(expression);
    }

    private static String[] split(String value) {
        return value.split(SEPARATOR);
    }

}
