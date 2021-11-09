package view;

import java.util.Scanner;

public class InputView {
    private final static Scanner scanner = new Scanner(System.in);
    private static final String NUMBER_TYPE_ERROR_MESSAGE = "error : 아라비아 숫자만 입력할수 있습니다.";
    private static final String RACE_CAR_COUNT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private static final String CAR_RACE_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public static String inputRaceCarName() {
        System.out.println(RACE_CAR_COUNT_MESSAGE);

        return scanner.nextLine();
    }

    public static int inputCarRaceCount() {
        System.out.println(CAR_RACE_COUNT_MESSAGE);

        return checkNumberType();
    }

    private static int checkNumberType() {
        if (!scanner.hasNextInt()) {
            throw new IllegalArgumentException(NUMBER_TYPE_ERROR_MESSAGE);
        }

        return scanner.nextInt();
    }
}
