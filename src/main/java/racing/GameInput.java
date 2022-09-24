package racing;

import java.util.Scanner;

public class GameInput {

    private final Scanner scanner = new Scanner(System.in);

    public Integer racerCount() {
        return scanner.nextInt();
    }

    public Integer roundCount() {
        return scanner.nextInt();
    }
}
