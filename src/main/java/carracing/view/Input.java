package carracing.view;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static String insertCarName() {
        return scanner.nextLine();
    }

    public static int insertGameCount() {
        return scanner.nextInt();
    }
}
