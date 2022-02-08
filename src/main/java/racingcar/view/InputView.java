package racingcar.view;

import java.util.Scanner;

public class InputView {

    public static String[] getCarName() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        return userInput.split(",");
    }

    public static int getTryCount() {
        Scanner scanner = new Scanner(System.in);
        int tryCount = scanner.nextInt();

        return tryCount;
    }
}
