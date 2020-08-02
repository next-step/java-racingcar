import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            String expression = scanner.nextLine();

            ArithmeticArguments arguments = ArithmeticArgumentFactory.createArgs(expression);

            int result = Calculator.calculate(arguments);

            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
