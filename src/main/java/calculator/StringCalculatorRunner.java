package calculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringCalculatorRunner {

    /* StringCalculator 내부 여러기능 존재
     * - StringCalculator.inputText() method 분리
     */
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();

        int result = StringCalculator.calculate(text);

        //view result
        StringCalculatorResultViewer.viewResult(result);

    }
}
