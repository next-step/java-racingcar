package racing.view;

import java.util.Scanner;

public final class Input {
    private Input() {
    }

    public static String carNames() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int gameCount() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
