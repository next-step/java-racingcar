package racingCar;

import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static int getInput(String message) {
        System.out.println(message);

        return Integer.parseInt(scanner.nextLine());
    }
}
