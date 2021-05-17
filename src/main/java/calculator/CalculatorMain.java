package calculator;

public class CalculatorMain {
    public static void main(String[] args) {
        CalculatorView calculatorView = new CalculatorView();
        String str = calculatorView.inputString();

        CalculatorService calculatorService = new CalculatorService(str);
        calculatorService.isBlank();
        calculatorService.checkSymbok();
        int result = calculatorService.calculateSplitedString();
        calculatorView.showResult(result);
    }
}
