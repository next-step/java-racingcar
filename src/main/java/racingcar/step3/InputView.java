package racingcar.step3;

import java.util.Scanner;

public class InputView {

    public static final String CARS_NUMBER_HELP_MESSAGE = "자동차 대수는 몇 대 인가요?";
    public static final String ROUNDS_NUMBER_HELP_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private final Scanner scanner = new Scanner(System.in);

    public int getCarsNumbersInput() {
        return getUserIntegerInput(CARS_NUMBER_HELP_MESSAGE);
    }

    public int getRoundsNumberInput() {
        return getUserIntegerInput(ROUNDS_NUMBER_HELP_MESSAGE);
    }

    private int getUserIntegerInput(String helpMessage) {
        System.out.println(helpMessage);

        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            throw new NumberFormatException("값은 숫자만 입력할 수 있습니다.");
        }
    }
}
