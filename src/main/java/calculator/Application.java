package calculator;

import calculator.domain.Calculator;
import calculator.domain.PivotContainer;
import calculator.view.UserInput;

public class Application {

    public static void main(String[] args)  {
        UserInput userInput = new UserInput();
        PivotContainer pivotContainer = PivotContainer.from(userInput.typeUserInput());
        Calculator calculator = new Calculator();

        double result = calculator.doMultipleOperation(pivotContainer.getNumbers(), pivotContainer.getOperators());
        System.out.println("계산결과: "+ result);
    }
}
