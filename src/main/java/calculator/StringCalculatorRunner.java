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
        String inputData = InputView.input();
        //validate data
        boolean isWrong = InputView.validate(inputData);

        if (isWrong) {
            System.out.println("please check expression : " + inputData);
            return;
        }
        //splitExpression
        String[] expression = InputView.splitExpression(inputData);

        //---------------------------- model
        //calculrate
        int result = StringCalculator.calculate(expression);
        //---------------------------- outPutView
        //resultView
        OutputView.printResult(result);

    }
}
