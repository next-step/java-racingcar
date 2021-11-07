import stringcalculator.StringCalculator;
import stringcalculator.console.InputConsole;
import stringcalculator.console.OutputConsole;

public class Application {
    public static void main(String[] args) {
        OutputConsole.printExpression(StringCalculator.calculate(InputConsole.readExpression()));
    }
}
