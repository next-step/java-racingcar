package calculator;

import calculator.domain.Calculator;
import calculator.domain.PivotContainer;
import calculator.view.UserInput;

public class Application {

    public static void main(String[] args)  {
        PivotContainer pivotContainer = PivotContainer.get(UserInput.console().getLine());

        double result = Calculator.get().doMultipleOperation(pivotContainer.getNumbers(), pivotContainer.getOperators());
        System.out.println("계산결과: "+ result);
    }
}
