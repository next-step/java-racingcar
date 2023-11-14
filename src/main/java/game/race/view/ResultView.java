package game.race.view;

import java.util.List;

import game.race.domain.Car;

public class ResultView {

    private static final String SHOW_RESULT = "실행 결과";
    private static final String END_MARK = "";
    private static final String MARK = "-";

    public static void showPrompt() {
        System.out.println(SHOW_RESULT);
    }

    public static void showCars(List<String> vehicleNames, List<Car> cars) {
        for (int idx = 0; idx < cars.size(); idx++) {
            printMark(vehicleNames.get(idx), cars.get(idx).getMoveCount());
        }

        System.out.println(END_MARK);
    }

    private static void printMark(String vehicleName, int moveCount) {
        String tireMark = (moveCount == 0) ? MARK : MARK.repeat(moveCount);
        System.out.println(vehicleName + " : " + tireMark);
    }

    public static void printWinners(List<String> winners) {
        String winner = String.join(", ", winners);
        System.out.println(winner + "가 최종 우승했습니다.");
    }
}
