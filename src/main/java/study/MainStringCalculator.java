package study;

import java.util.Scanner;

public class MainStringCalculator {

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.execute(input);

        System.out.println("계산식 : " + input);
        System.out.println("결과 : " + result);
    }
}
