package racinggame;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static void displayCarInput() {
        String text = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
        System.out.println(text);
    }

    public static void displayRoundInput() {
        String text = "시도할 회수는 몇 회 인가요?";
        System.out.println(text);
    }

    public static int getUserInputToInt() {
        return scanner.nextInt();
    }

    public static String getNextString() {
        return scanner.nextLine();
    }
}
