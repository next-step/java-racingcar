package stringcalculator.ui;

import stringcalculator.application.ExpressionService;

public class ExpressionController {

    private final ExpressionService expressionService;


    public ExpressionController(ExpressionService expressionService) {
        this.expressionService = expressionService;
    }

    public double calculate(InputView inputView) {
        return expressionService.calculate(inputView.toExpression());
    }
}
