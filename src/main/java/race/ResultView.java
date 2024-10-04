package race;

import java.util.List;

public class ResultView {
    private static final String CAR_NAMES_REQUEST_STATEMENT = "경주할 자동차 이름을 입력하세요(각 이름은 5글자 이하, 자동차는 최소 2대 이상이며, 쉼표(,)를 기준으로 구분)";
    private static final String GAME_COUNT_REQUEST_STATEMENT = "시도할 회수는 몇 회 인가요? (1 이상의 숫자 입력)";
    private static final String CAR_STATE_MARKER = "-";
    public static final String RESULT_TITLE = "실행 결과";
    public static final String CAR_NUMBER_POSTFIX = "번 차: ";
    public static final String LINE_BREAK = "%n";

    public static void printCarNamesRequestMessage() {
        System.out.println(CAR_NAMES_REQUEST_STATEMENT);
    }

    public static void printGameCountRequestMessage() {
        System.out.println(GAME_COUNT_REQUEST_STATEMENT);
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printResultTitle() {
        System.out.printf(LINE_BREAK + RESULT_TITLE + LINE_BREAK);
    }

    public static void printCarStates(List<RacingCar> cars) {
        for (int carIndex = 0; carIndex < cars.size(); carIndex++) {
            RacingCar car = cars.get(carIndex);
            int carNumber = carIndex + 1;
            System.out.print(carNumber + CAR_NUMBER_POSTFIX);
            printSingleCarState(car.state());
        }
        System.out.printf(LINE_BREAK);
    }

    private static void printSingleCarState(int carState) {
        for (int i = 0; i < carState; i++) {
            System.out.print(CAR_STATE_MARKER);
        }
        System.out.printf(LINE_BREAK);
    }
}
