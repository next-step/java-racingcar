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

    public static void showCars(List<Car> cars) {
        cars.forEach(car -> printMark(car.getName(), car.getMoveCount()));
        System.out.println(END_MARK);
    }

    private static void printMark(String vehicleName, int moveCount) {
        String tireMark = (moveCount == 0) ? MARK : MARK.repeat(moveCount);
        System.out.println(vehicleName + " : " + tireMark);
    }

    public static void printWinners(List<Car> winners) {
        String win = "";
        for (Car winner : winners) {
            win = String.join(",", winner.getName());
        }

        System.out.println(win + "가 최종 우승했습니다.");
    }
}
