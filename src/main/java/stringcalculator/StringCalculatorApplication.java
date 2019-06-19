package stringcalculator;

import stringcalculator.application.ExpressionService;
import stringcalculator.ui.ExpressionController;
import stringcalculator.ui.InputView;
import stringcalculator.ui.ResultView;

public class StringCalculatorApplication {

    public static ExpressionService expressionService;
    public static ExpressionController expressionController;

    public static void main(String[] args) {
        postConstructor();

        InputView inputView = new InputView();
        ResultView resultView = new ResultView(expressionController.calculate(inputView));
        resultView.print();
    }

    public static void postConstructor() {
        expressionService = new ExpressionService();
        expressionController = new ExpressionController(expressionService);
    }
}
