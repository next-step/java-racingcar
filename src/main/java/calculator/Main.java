package calculator;

import calculator.stringCalculator.InputString;
import calculator.stringCalculator.StringCalculator;
import calculator.stringCalculator.StringSeparator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringSeparator separator = new StringSeparator();
        StringCalculator calculator = StringCalculator.from(separator);

        Scanner scanner = new Scanner(System.in);
        System.out.print("문자열을 입력해주세요: ");
        InputString inputString = InputString.of(scanner.nextLine(), calculator);
        int result = inputString.calculate();
        System.out.println("결과 = " + result);
    }
}
