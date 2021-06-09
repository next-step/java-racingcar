package calculator;

public class CalculatorMain {
    public static void main(String[] args) {
        CalculatorView calculatorView = new CalculatorView();
        String inputFormula = calculatorView.inputString();

        CalculatorService calculatorService = new CalculatorService(inputFormula);
        calculatorService.checkSymbol();
        int result = calculatorService.calculateSplitedString();
        calculatorView.showResult(result);
    }
}
