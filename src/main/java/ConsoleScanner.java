import java.util.Scanner;

public class ConsoleScanner {
    private static final String CAR_NAME_INPUT_ANNOUNCEMENT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String EMPTY_CAR_NAME_ANNOUNCEMENT = "자동차 이름을 하나 이상 입력해주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static String getInputCarNames() {
        System.out.println(CAR_NAME_INPUT_ANNOUNCEMENT);
        String result = scanner.nextLine();

        while (result.isEmpty()) {
            System.out.println(EMPTY_CAR_NAME_ANNOUNCEMENT);
            result = scanner.nextLine();
        }

        return result;
    }
}
