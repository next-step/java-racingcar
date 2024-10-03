package race;

import java.util.List;

public class ResultView {
    private static final String CAR_STATE_MARKER = "-";
    public static final String RESULT_TITLE = "실행 결과";
    public static final String CAR_NUMBER_POSTFIX = "번 차: ";
    public static final String LINE_BREAK = "%n";


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
