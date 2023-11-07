package racingcar;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String HYPHEN = "-";

    private ResultView() {
    }

    public static void printResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printCarsPosition(List<RacingCar> cars) {
        cars.forEach(ResultView::printCarPosition);
        System.out.println();
    }

    private static void printCarPosition(RacingCar car) {
        System.out.println(buildCarPositionString(car));
    }

    private static String buildCarPositionString(RacingCar car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName());
        sb.append(" : ");
        sb.append(HYPHEN.repeat(car.getCarPosition()));
        return sb.toString();
    }

    public static void printWinner(String winner) {
        System.out.println(winner + "가 최종 우승했습니다.");
    }
}
