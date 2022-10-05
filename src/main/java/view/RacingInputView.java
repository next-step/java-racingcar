package view;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class RacingInputView {

    public static RacingInput getInputFromUser() {
        final int carCount = _getCarCountFromUser();
        final int trialCount = _getTrialCountFromUser();

        return new RacingInput(carCount, trialCount);
    }

    private static int _getCarCountFromUser() {
        return _getPositiveIntegerInputAndRetryWhenException(
                "자동차 대수는 몇 대인가요?",
                "자동차 수는 양의 정수만 입력 가능합니다.\n"
        );
    }

    private static int _getTrialCountFromUser() {
        return _getPositiveIntegerInputAndRetryWhenException(
                "시도할 횟수는 몇 회인가요?",
                "시도할 횟수는 양의 정수만 입력 가능합니다.\n"
        );
    }

    private static int _getPositiveIntegerInputAndRetryWhenException(String firstTryMessage, String retryMessage) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(firstTryMessage);
        try {
            return getPositiveIntegerInput(scanner);
        } catch (NoSuchElementException e) {
            System.out.println(retryMessage);
            return _getPositiveIntegerInputAndRetryWhenException(firstTryMessage, retryMessage);
        }
    }

    // 쓰임새만 보면 private 처리하고 싶은데, 테스트코드에서 사용해야 해서 public 처리했습니다.
    public static int getPositiveIntegerInput(Scanner scanner) throws InputMismatchException {
        int input = scanner.nextInt();
        if (input <= 0) {
            throw new InputMismatchException();
        }
        return input;
    }
}
