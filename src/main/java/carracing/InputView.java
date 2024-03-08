package carracing;

import java.util.Scanner;

public class InputView {
    public static String NUMBER_OF_CARS_INPUT_GUIDE_MESSAGE = "자동차 대수는 몇 대 인가요?";
    public static String NUMBER_OF_ATTEMPTS_INPUT_GUIDE_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private InputView() {
    }

    public static int enteredNumber(String guideMessage) {
        System.out.println(guideMessage);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        // 검증 필요 - null, blank, 문자 포함 여부 확인

        int numberOfAttempts = Integer.parseInt(input);

        // 검증 필요 - 음수, 0 검증

        return numberOfAttempts;
    }
}
