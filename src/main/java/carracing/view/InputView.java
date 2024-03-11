package carracing.view;

import java.util.Scanner;

public class InputView {
    public static final String NUMBER_OF_CARS_INPUT_GUIDE_MESSAGE = "자동차 대수는 몇 대 인가요?";
    public static final String NUMBER_OF_ATTEMPTS_INPUT_GUIDE_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private InputView() {
    }

    public static String enteredNumber(String guideMessage) {
        System.out.println(guideMessage);

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
