package step3.view;

import step3.view.dto.InputDto;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    public static InputDto load() {
        int carNumber = inputCarNumber();
        int attemptNumber = inputAttemptNumber();
        return InputDto.of(carNumber, attemptNumber);
    }

    private static int inputAttemptNumber() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    private static int inputCarNumber() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

}