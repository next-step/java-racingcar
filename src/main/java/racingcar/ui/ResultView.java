package racingcar.ui;

import racingcar.domain.Car;
import racingcar.domain.RaceGame;

import java.util.List;

public class ResultView {

    public static final String DASH = "-";
    public static final String EXECUTE_RESULT = "실행 결과";

    public static void printExecuteMessage() {
        System.out.println(EXECUTE_RESULT);
    }

    public static void print(RaceGame raceGame) {
        List<Car> cars = raceGame.getCars();
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + convertPositionToDash(car.getPosition()));
        }
        System.out.println();
    }

    private static String convertPositionToDash(int position) {
        return DASH.repeat(Math.max(0, position));
    }

    public static void printWinnersName(RaceGame raceGame) {
        String winnersName = String.join(",", raceGame.getWinnersName());
        System.out.println(winnersName + "가 최종 우승했습니다.");
    }
}
