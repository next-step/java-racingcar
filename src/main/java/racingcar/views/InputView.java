package racingcar.views;

import racingcar.exceptions.InvalidStringDataException;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputView {

    private static final String QUESTION_CAR_NAME_TOTAL = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String QUESTION_ROUND_NUM_TOTAL = "시도할 회수는 몇 회 인가요?";

    private static final String CAR_NAME_TOTAL = "CAR_NAME_TOTAL";
    private static final String ROUND_NUM_TOTAL = "ROUND_NUM_TOTAL";

    private static Map<String, String> racingCarInfos = new HashMap<>();

    private InputView() {}

    public static void startInput() {
        Scanner scanner = new Scanner(System.in);

        askCarInfo(QUESTION_CAR_NAME_TOTAL);
        getAnswerForCarInfo(scanner, CAR_NAME_TOTAL);

        askCarInfo(QUESTION_ROUND_NUM_TOTAL);
        getAnswerForCarInfo(scanner, ROUND_NUM_TOTAL);

        scanner.close();
    }

    private static void askCarInfo(String question) {
        System.out.println(question);
    }

    private static void getAnswerForCarInfo(Scanner scanner,
                                            String infoType) {

        if (scanner.hasNextLine()) {
            String value = scanner.nextLine();
            racingCarInfos.put(infoType, value);
        }
    }

    public static String getRacingCarNames() {
        return racingCarInfos.get(InputView.CAR_NAME_TOTAL);
    }

    public static int getRoundNumTotal() {
        String strRoundNumTotal = racingCarInfos.get(InputView.ROUND_NUM_TOTAL);

        if (strRoundNumTotal == null || strRoundNumTotal.isEmpty()) {
            throwInvalidStringDataException();
        }

        return Integer.parseInt(strRoundNumTotal);
    }

    private static void throwInvalidStringDataException() {
        try {
            throw new InvalidStringDataException("Invalid Round Number Exception!");
        } catch (InvalidStringDataException e) {
            e.printStackTrace();
        }
    }

}
