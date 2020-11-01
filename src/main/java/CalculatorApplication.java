import java.util.Scanner;

public class CalculatorApplication {
    private static final String SPLITTER = " ";

    public static void main (String args[]) {
        StringCalculator stringCalculator = new StringCalculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("식을 입력해 주세요.");
        String inputString = scanner.nextLine();

        String[] expressionArray = inputString.split(SPLITTER);

        Double result = Double.valueOf(expressionArray[0]);
        for (int i = 1; i < expressionArray.length - 1; i += 2) {
            String operator = stringCalculator.getOperator(expressionArray, i);
            stringCalculator.isNotBlank(operator);

            Double rightNumber = stringCalculator.isDigit(stringCalculator.getRightNumber(expressionArray, i));

            result = stringCalculator.calculator(result, operator, rightNumber);
        }

        System.out.println(result);
    }
}
