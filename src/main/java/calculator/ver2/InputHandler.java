package calculator.ver2;

import java.util.Scanner;

public class InputHandler {
    public static String input() {
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextLine();
        } catch (Exception e) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
    }

}
