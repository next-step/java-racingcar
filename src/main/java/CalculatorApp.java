import study.Calculator;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char yn;

        Calculator calculator = new Calculator();
        boolean replay = true;

        while (replay) {
            System.out.println("ex) 1 + 2 + 3 + 5 + 7 - 숫자와 구분자는 꼭 띄워주세요.");

            String input = calculator.input();
            int result = calculator.makeResult(input);
            System.out.println(result);

            System.out.println("다시 계산하시겠습니까?");
            yn = scanner.next().charAt(0);
            if (yn == 'y' || yn == 'Y') {
                replay = true;
            } else {
                replay = false;
            }
        }
    }
}
