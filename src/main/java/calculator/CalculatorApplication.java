package calculator;

import java.util.Scanner;

public class CalculatorApplication {

    public static void main(String[] args) {
        Input input = new Input(
            new Scanner(System.in)
        );

        StringCalculator stringCalculator = new StringCalculator();
        double result = stringCalculator.calculate(
            input.input("문자열을 입력하세요: ")
        );
        System.out.println("계산 결과: " + result);
    }
}
