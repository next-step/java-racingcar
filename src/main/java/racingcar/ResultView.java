package racingcar;

public class ResultView {
    private static final String PRINT_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String PRINT_TRY_COUNT = "시도할 회수는 몇 회 인가요?";
    private static final String PRINT_RESULT_MESSAGE = "실행 결과";
    private static final String PRINT_GO_DISTANCE = "-";
    private static final String PRINT_RACE_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    public static void printCarCount() {
        System.out.println(PRINT_CAR_COUNT);
    }

    public static void printTryCount() {
        System.out.println(PRINT_TRY_COUNT);
    }

    public static void printResultMessage() {
        System.out.println(PRINT_RESULT_MESSAGE);
    }

    public static void printGoDistance(int distance) {
        for (int i = 0; i < distance; i++) {
            System.out.print(PRINT_GO_DISTANCE);
        }
        System.out.println();
    }

    public static void printRaceCarName(){
        System.out.println(PRINT_RACE_CAR_NAME);
    }
}
