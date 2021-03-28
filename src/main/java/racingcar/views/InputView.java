package racingcar.views;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputView {

    private static final String QUESTION_CAR_NUM_TOTAL = "자동차 대수는 몇 대 인가요?";
    private static final String QUESTION_ROUND_NUM_TOTAL = "시도할 회수는 몇 회 인가요?";

    public static final String CAR_NUM_TOTAL = "CAR_NUM_TOTAL";
    public static final String ROUND_NUM_TOTAL = "ROUND_NUM_TOTAL";

    private InputView() {}

    public static Map<String, Integer> input() {
        Map<String, Integer> racingCarInfos  = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        askCarInfo(QUESTION_CAR_NUM_TOTAL);
        getAnswerForCarInfo(racingCarInfos, scanner, CAR_NUM_TOTAL);

        askCarInfo(QUESTION_ROUND_NUM_TOTAL);
        getAnswerForCarInfo(racingCarInfos, scanner, ROUND_NUM_TOTAL);

        scanner.close();

        return racingCarInfos;
    }

    private static void askCarInfo(String question) {
        System.out.println(question);
    }

    private static void getAnswerForCarInfo(Map<String, Integer> racingCarInfos,
                                            Scanner scanner,
                                            String infoType) {

        if (scanner.hasNextLine()) {
            int value = scanner.nextInt();
            racingCarInfos.put(infoType, value);
        }
    }

}
