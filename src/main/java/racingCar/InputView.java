package racingCar;

import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static String getInput(String message) {
        System.out.println(message);

        return scanner.nextLine();
    }
}
