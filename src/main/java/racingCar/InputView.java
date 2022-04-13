package racingCar;

import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static int getInput(String message) {
        System.out.println(message);

        return toInt(scanner.nextLine());
    }

    public static int toInt(String input) {
        int number = Integer.parseInt(input);
        if (number < 0) {
            throw new RuntimeException();
        }

        return number;
    }
}
