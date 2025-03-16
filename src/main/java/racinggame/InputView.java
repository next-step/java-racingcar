package racinggame;

import java.util.Scanner;
import racinggame.exception.NotPositiveNumberException;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {

    }

    public static int getCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return getInput();
    }

    public static int getRounds() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return getInput();
    }

    private static int getInput() {
        int input = Integer.parseInt(scanner.nextLine());
        if (input < 0) {
            throw new NotPositiveNumberException();
        }
        return input;
    }
}
