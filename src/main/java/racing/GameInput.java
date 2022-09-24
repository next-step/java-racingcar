package racing;

import java.util.Scanner;

public class GameInput {

    private final Scanner scanner = new Scanner(System.in);

    public int carCount() {
        return scanner.nextInt();
    }

    public int roundCount() {
        return scanner.nextInt();
    }
}
