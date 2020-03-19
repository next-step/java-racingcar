package calculator;

import java.util.Scanner;

public class CalculatorApplication {
    public static void main(String[] args) {
        System.out.println("사칙연산을 수행하고 싶은 문자열을 입력해 주세요. (단, 모든 숫자와 연산자는 공백으로 구분되어야 합니다)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        InputView inputView = new InputView(input);
        InputArray inputArray = new InputArray(inputView);
        Calculator calculator = new Calculator(inputArray);

        double result = calculator.calculateAll();
        System.out.println("연산결과 : " + result);
    }
}
