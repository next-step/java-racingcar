package racingcar.views;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputView {

    public static final String QUESTION_TOTAL_CAR_NUM = "자동차 대수는 몇 대 인가요?";
    public static final String QUESTION_TOTAL_MOVE_CNT = "시도할 회수는 몇 회 인가요?";

    public static final String KEY_TOTAL_CAR_NUM = "totalCarNum";
    public static final String KEY_TOTAL_MOVE_CNT = "totalMoveCnt";

    public static Map<String, Integer> getInput() {
        Map<String, Integer> racingCarInfos = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        askCarInfos(racingCarInfos, scanner, QUESTION_TOTAL_CAR_NUM, KEY_TOTAL_CAR_NUM);
        askCarInfos(racingCarInfos, scanner, QUESTION_TOTAL_MOVE_CNT, KEY_TOTAL_MOVE_CNT);

        scanner.close();

        return racingCarInfos;
    }

    private static void askCarInfos(Map<String, Integer> racingCarInfos,
                                     Scanner scanner,
                                     String question,
                                     String infoType) {

        System.out.println(question);

        while (scanner.hasNextLine()) {
            int value = scanner.nextInt();
            System.out.println(value);

            racingCarInfos.put(infoType, value);
        }
    }

}
