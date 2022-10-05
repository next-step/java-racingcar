package racing.view;

import racing.UserInputException;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public int inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return UserInputException.isValidForNumber((inputNumber()));
    }

    public int inputTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return UserInputException.isValidForNumber((inputNumber()));
    }

    private static String inputNumber() {
        return scanner.nextLine();
    }
}
