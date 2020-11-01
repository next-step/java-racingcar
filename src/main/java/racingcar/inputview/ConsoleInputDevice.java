package racingcar.inputview;

import java.util.Scanner;

public class ConsoleInputDevice implements InputDevice {
    private final Scanner scanner;

    public ConsoleInputDevice() {
        scanner = new Scanner(System.in);
    }

    @Override
    public int getIntNumber() {
        return scanner.nextInt();
    }

    @Override
    public String getString() {
        return scanner.next();
    }
}
