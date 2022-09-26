import static calculator.StringCalculator.splitAndCalculate;

import java.util.Scanner;

public class StringCalculatorApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("계산하고 싶은 문자열을 입력해 주세요.");
        String input = scanner.next();

        System.out.println("계산하려는 연산 방법을 부호로 입력해 주세요.");
        String operator = scanner.next();

        int result = splitAndCalculate(input, operator);
        System.out.printf("입력 하신 [ %s ] 의 결과 값은 [ %d ] 입니다.", input, result);
    }
}
