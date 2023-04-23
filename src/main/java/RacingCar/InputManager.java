package RacingCar;

import java.util.Scanner;

public class InputManager {
    private final Scanner scanner;

    public InputManager() {
        scanner = new Scanner(System.in);
    }

    public int getUserInput() {
        return Integer.parseInt(scanner.nextLine());
    }
}
