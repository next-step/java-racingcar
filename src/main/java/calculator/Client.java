package calculator;

import java.util.Scanner;

/**
 * ex) input : 2 + 3 * 4 / 2
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("숫자를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        Long result = calculator.execute(scanner.nextLine());
        System.out.println(String.format("결과 : %d", result));
    }
}