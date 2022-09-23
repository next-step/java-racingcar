package racing;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int input(String question) {
        System.out.println(question);
        return scanner.nextInt();
    }
}
