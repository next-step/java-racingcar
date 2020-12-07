package calculator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StringCalculatorRunner {
    private Scanner scanner;

    public StringCalculatorRunner() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * running baseball game.
     */
    public void run() {
        System.out.print("연산을 입력해주세요 : ");
        String input = this.scanner.nextLine();
        try {
            System.out.println("입력 : " + input);
            StringCalculator stringCalculator = new StringCalculator(input);
            System.out.println("결과 : " + stringCalculator.calculate());
        } catch (Exception e) {
            System.out.println("올바른 값을 입력해주세요.");
        }
    }
}
