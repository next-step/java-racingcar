package carracing;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public String insertCarName() {
        return scanner.nextLine();
    }

    public int insertGameCount() {
        return scanner.nextInt();
    }
}
