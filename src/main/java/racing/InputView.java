package racing;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int requestNumber(String text) {
        System.out.println(text);
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            throw new RuntimeException("잘못 입력하셨습니다");
        }
    }

}

