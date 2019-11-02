package calculator;

import calculator.StringCalculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringCalculatorMain {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String valueToCalculate = bufferedReader.readLine();
        try {
            StringCalculator stringCalculator = new StringCalculator(valueToCalculate);
            System.out.println(stringCalculator.calculate());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Input value error", e);
        }
        bufferedReader.close();
    }
}
