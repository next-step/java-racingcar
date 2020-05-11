import domain.Calculator;
import domain.Operand;
import view.InputView;
import view.OutputView;

public class CalculatorApplication {

    public static void main(String[] args) {
        String inputEquation = InputView.askEquation();

        Operand result = Calculator.calculate(inputEquation);

        OutputView.printResult(result.getValue());
    }
}
