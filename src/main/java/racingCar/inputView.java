package racingCar;

import java.util.Scanner;

public class inputView {
    private final Scanner scanner = new Scanner(System.in);

    public int getInputNumber(String question) {
        System.out.println(question);
        return scanner.nextInt();
    }
}
