import java.util.Scanner;

public class CalculatorApplication {
    public static void main (String args[]) {
        StringCalculator stringCalculator = new StringCalculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("식을 입력해 주세요.");
        String inputString = scanner.nextLine();

        String[] strings = inputString.split(" ");

        int result = Integer.parseInt(strings[0]);
        for (int i = 1; i < strings.length - 1; i += 2) {
            String operator = strings[i];
            stringCalculator.isNotBlank(operator);
            stringCalculator.isOperator(operator);
            result = stringCalculator.calculator(result, operator, Integer.parseInt(strings[i + 1]));
        }

        System.out.println(result);
    }
}
