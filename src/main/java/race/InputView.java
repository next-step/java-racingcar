package race;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public int inputCar() {
        return scanner.nextInt();
    }

    public int inputTry() {
        return scanner.nextInt();
    }
}
