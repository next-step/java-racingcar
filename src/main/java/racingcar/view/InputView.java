package racingcar.view;

import java.util.Scanner;

public class InputView {

    public String[] getCarName() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        return userInput.split(",");
    }

    public int getTryCount() {
        Scanner scanner = new Scanner(System.in);
        int tryCount = scanner.nextInt();

        return tryCount;
    }
}
