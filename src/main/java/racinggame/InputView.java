package racinggame;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static void displayCarInput() {
        String text = "자동차 대수는 몇 대 인가요?";
        System.out.println(text);
    }

    public static void displayRoundInput() {
        String text = "시도할 회수는 몇 회 인가요?";
        System.out.println(text);
    }

    public static int getUserInputToInt() {
        return scanner.nextInt();
    }
}
