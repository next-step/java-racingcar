package racinggame;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_MESSAGE_OF_NUMBER_OF_CAR = "자동차 대수는 몇 대 인가요?";
    private static final String INPUT_MESSAGE_OF_TRY_COUNT = "시도할 횟수는 몇 회 인가요?";

    private final Scanner scanner = new Scanner(System.in);

    public int inputNumberOfCar() {
        System.out.println(INPUT_MESSAGE_OF_NUMBER_OF_CAR);
        return parsePositiveInt(scanner.nextLine());
    }

    public int inputTryCount() {
        System.out.println(INPUT_MESSAGE_OF_TRY_COUNT);
        return parsePositiveInt(scanner.nextLine());
    }

    private int parsePositiveInt(String input) {
        int num = Integer.parseInt(input);
        if (num <= 0) {
            throw new RuntimeException("0 또는 음수는 전달할 수 없습니다.");
        }
        return num;
    }

}
