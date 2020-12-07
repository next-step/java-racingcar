package calculator;

public class Application {

    public static void main(String[] args) {
        String input = ConsoleView.input();
        int result = StringCalculator.calculate(input);
        ConsoleView.showResult(result);
    }
}
