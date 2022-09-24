import java.util.Scanner;

public class InputView {

    public static final String INPUT_MESSAGE_OF_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    public static final String INPUT_MESSAGE_OF_TRY_COUNT = "시도할 회수는 몇 회 인가요?";

    public static int inputCarCount() {
        return inputIntegerWithMessage(INPUT_MESSAGE_OF_CAR_COUNT);
    }

    public static int inputTryCount() {
        return inputIntegerWithMessage(INPUT_MESSAGE_OF_TRY_COUNT);
    }

    public static int inputIntegerWithMessage(String msg) {
        System.out.println(msg);
        return inputIntByScanner();
    }

    public static int inputIntByScanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
