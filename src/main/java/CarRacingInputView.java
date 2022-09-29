import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CarRacingInputView {

    public static int getCarCountFromUser() {
        return getPositiveIntegerInputAndRetryWhenException(
                "자동차 대수는 몇 대인가요?",
                "자동차 수는 양의 정수만 입력 가능합니다.\n"
        );
    }

    public static int getTrialCountFromUser() {
        return getPositiveIntegerInputAndRetryWhenException(
                "시도할 횟수는 몇 회인가요?",
                "시도할 횟수는 양의 정수만 입력 가능합니다.\n"
        );
    }

    private static int getPositiveIntegerInputAndRetryWhenException(String firstTryMessage, String retryMessage) {
        System.out.println(firstTryMessage);
        Scanner scanner = new Scanner(System.in);
        try {
            return getPositiveIntegerInput(scanner);
        } catch (NoSuchElementException e) {
            System.out.println(retryMessage);
            return getPositiveIntegerInputAndRetryWhenException(firstTryMessage, retryMessage);
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
