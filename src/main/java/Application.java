import stringcalculator.StringCalculator;
import stringcalculator.arithmeticcomponent.ArithmeticResult;
import stringcalculator.console.InputConsole;
import stringcalculator.console.InputExpression;
import stringcalculator.console.OutputConsole;

public class Application {
    public static void main(String[] args) {
        InputExpression inputExpression = InputConsole.readExpression();
        ArithmeticResult arithmeticResult = StringCalculator.calculate(inputExpression);
        OutputConsole.printExpression(arithmeticResult);
    }
}
