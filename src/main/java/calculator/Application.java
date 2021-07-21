package calculator;

import calculator.domain.Calculator;
import java.util.Scanner;

public class Application {

    public static final String ASK_INPUT = "연산할 문자열을 입력해 주세요 (숫자와 사칙 연산 사이에는 빈 공백 문자열이 필요합니다) :";

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String input = askForUserInput(scanner);
        int result = Calculator.calculate(input);
        System.out.println("결과값 : " + result);
    }

    private static String askForUserInput(Scanner scanner) {
        System.out.println(ASK_INPUT);
        return scanner.nextLine();
    }
}
