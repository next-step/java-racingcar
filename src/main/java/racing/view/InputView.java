package racing.view;

import java.util.Scanner;

public class InputView {
    private static final String CARS_NAME_DELIMITER = ",";
    private static final int DEFAULT_TRY_CNT = 0;
    private static final String GET_CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String GET_GAME_CNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String INVALID_STRING_INPUT_MSG = "비어있지 않은 문자열을 입력 해 주세요!";
    private static final String INVALID_INT_INPUT_MSG = "양의 정수 값을 입력 해 주세요!";

    private static final Scanner scanner = new Scanner(System.in);

    public static String[] getCarNames() {
        String carNames;
        do {
            System.out.println(GET_CARS_NAME_MESSAGE);

            carNames = scanner.nextLine();
        } while(!isCarNameValid(carNames));

        return carNames.split(CARS_NAME_DELIMITER);
    }

    private static boolean isCarNameValid(String carNames) {
        if (!ValidChecker.isInputValid(carNames)) {
            printInvalidStringMessage();
            return false;
        }

        return true;
    }

    public static int getTryCnt() {
        int tryCnt;
        do {
            System.out.println(GET_GAME_CNT_MESSAGE);

            tryCnt = parseTryCnt();
        } while (!isTryCountValid(tryCnt));

        return tryCnt;
    }

    private static boolean isTryCountValid(int tryCnt) {
        if (!ValidChecker.isInputValid(tryCnt)) {
            printInvalidIntMessage();
            return false;
        }

        return true;
    }

    private static int parseTryCnt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return DEFAULT_TRY_CNT;
        }
    }

    public static void printInvalidStringMessage() {
        System.out.println(INVALID_STRING_INPUT_MSG);
    }

    public static void printInvalidIntMessage() {
        System.out.println(INVALID_INT_INPUT_MSG);
    }
}
