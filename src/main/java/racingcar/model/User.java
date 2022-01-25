package racingcar.model;

import java.util.ArrayList;
import java.util.Scanner;
import racingcar.util.Message;

public class User {

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
