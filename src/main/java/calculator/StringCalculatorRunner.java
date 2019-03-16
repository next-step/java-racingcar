package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;

public class StringCalculatorRunner {

    /* StringCalculator 내부 여러기능 존재
     * - StringCalculator.inputText() method 분리
     */
    public static void main(String[] args) throws Exception {

        //---------------------------- inputView
        //input expression
        InputView inputView = new InputView();
        String[] expression = inputView.input();

        if(expression == null) {
            return;
        }

        //---------------------------- model
        //calculate
        int result = StringCalculator.calculate(expression);
        //---------------------------- outPutView
        //resultView
        OutputView.printResult(result);

    }
}
